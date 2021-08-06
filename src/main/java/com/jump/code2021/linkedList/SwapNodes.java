package com.jump.code2021.linkedList;

public class SwapNodes {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow=head;
        ListNode fast=head;
        int i=1;
        while(fast!=null && i<k ){
            fast = fast.next;
            i++;
        }

        ListNode posK = fast;
        ListNode negK = null;

        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        negK = slow;

        int tmp = posK.val;
        posK.val = negK.val;
        negK.val = tmp;

        return head;
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

        SwapNodes s = new SwapNodes();
        ListNode r = s.swapNodes(n1,2);
    }
}
