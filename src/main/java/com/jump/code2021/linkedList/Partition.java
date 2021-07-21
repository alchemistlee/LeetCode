package com.jump.code2021.linkedList;

public class Partition {


    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    public ListNode partition(ListNode head, int x) {
        ListNode sHead = new ListNode();
        ListNode sEnd = sHead;

        ListNode bHead = new ListNode();
        ListNode bEnd = bHead;

        ListNode cur = head.next;
        while (cur!=null){
            if(cur.val>=x){
                bEnd.next = cur;
                bEnd = cur;
            }
            else{
                sEnd.next = cur;
                sEnd = cur;
            }
            cur=cur.next;
        }

        bEnd.next=null;
        sEnd.next = bHead.next;

        return sHead;
    }

    public static void main(String[] args){
        ListNode h1 = new ListNode();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n31 = new ListNode(2);
        ListNode n4 = new ListNode(5);
        ListNode n41 = new ListNode(2);
//        ListNode n5 = new ListNode(5);

        h1.next = n1;
        n1.next =n2;
        n2.next= n3;
        n3.next = n31;
        n31.next = n4;
        n4.next =n41;

        Partition p = new Partition();
        ListNode res = p.partition(h1,3);
        System.out.println(res);
    }
}
