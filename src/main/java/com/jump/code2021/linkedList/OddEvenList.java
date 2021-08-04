package com.jump.code2021.linkedList;

public class OddEvenList {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead= null;
        ListNode evenHead=null;
        ListNode oddTail =null;
        ListNode evenTail =null;

        ListNode cur= head;
        int i=1;
        while (cur!=null){
            ListNode tmp = cur.next;

            if(i%2==0){
                if(evenHead==null){
                    evenHead = cur;
                    evenTail = cur;
                }
                else{
                    evenTail.next = cur;
                    evenTail = cur;
                }
                evenTail.next = null;
            }
            else{
                if(oddHead==null){
                    oddHead = cur;
                    oddTail = cur;
                }
                else{
                    oddTail.next = cur;
                    oddTail = cur;
                }
                oddTail.next =null;

            }
            cur = tmp;
            i++;
        }

        oddTail.next = evenHead;
        return oddHead;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        OddEvenList a = new OddEvenList();
        ListNode r = a.oddEvenList(n1);

    }
}
