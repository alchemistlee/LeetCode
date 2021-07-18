package com.jump.code2021.linkedList;

public class RemoveNthFromEnd {


    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int lastIdx = getReverseIdx(head.next, n);

        if(lastIdx>0){
            if(lastIdx==n){
                head.next=head.next.next;
            }
        }

        return head;

    }

    private int getReverseIdx(ListNode curnode, int n){
        if(curnode==null){
            return 0;
        }

        int subIdx = getReverseIdx(curnode.next, n);

        if(subIdx>0){

            if(subIdx==n){
                curnode.next = curnode.next.next;
            }

        }
        return subIdx+1;
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

        RemoveNthFromEnd r = new RemoveNthFromEnd();
        ListNode res = r.removeNthFromEnd(h1,5);

        System.out.println(res);


    }
}
