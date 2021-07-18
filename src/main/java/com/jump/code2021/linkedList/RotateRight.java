package com.jump.code2021.linkedList;

public class RotateRight {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    private ListNode tarListSta = null;
    private ListNode tarListEnd = null;

    public ListNode rotateRight(ListNode head, int k) {
        int listLen = extRevIdx(head.next, 600);

        int realK = k%listLen;

        if(realK == 0){
            return head;
        }
        else{
            extRevIdx(head.next, realK);

            tarListEnd.next= head.next;
            head.next =  tarListSta;
            return head;
        }
    }


    private int extRevIdx(ListNode n, int k){
        if(n==null){
            return 0;
        }

        int nextIdx= extRevIdx(n.next,k);

        int curIdx =nextIdx+1;

        if(nextIdx==k){
            tarListSta = n.next;
            n.next = null;
        }
        else if(nextIdx==0){
            tarListEnd = n;
        }

        return curIdx;
    }

    public static void main(String[] args){

        ListNode h1 = new ListNode();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        h1.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        RotateRight r = new RotateRight();
        ListNode res =  r.rotateRight(h1,7);

        System.out.println(res);
    }
}
