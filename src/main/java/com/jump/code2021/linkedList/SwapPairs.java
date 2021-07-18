package com.jump.code2021.linkedList;

public class SwapPairs {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    public ListNode swapPairs(ListNode head) {
        head.next =  swapIt(head.next);
        return head;
    }

    private ListNode swapIt(ListNode n){
        if(n==null){
            return null;
        }

        ListNode curHead = n;

        if(n.next!=null && n.val+1==n.next.val){
            curHead = n.next;

            ListNode t = n.next.next;
            n.next.next = n;
            n.next = t;
        }

        ListNode nextNode= swapIt(curHead.next);

        curHead.next = nextNode;

        return curHead;

    }

    public static void  main(String[] args){
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

        SwapPairs s = new SwapPairs();
        ListNode res = s.swapPairs(h1);

        System.out.println(res);

    }
}
