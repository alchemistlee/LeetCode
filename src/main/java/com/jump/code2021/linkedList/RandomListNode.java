package com.jump.code2021.linkedList;

import java.util.Random;

public class RandomListNode {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode h;
    private Random r ;

    public RandomListNode(ListNode head) {
        this.h= head;
        this.r = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur= this.h.next;


        int res = -1;
        int i=0;
        while (cur!=null){

            int randInt = this.r.nextInt(++i);

            if(randInt==0){
                res = cur.val;
            }

//            i++;
            cur=cur.next;
        }

        return res;
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

        ListNode h = new ListNode();
        h.next=n1;

        RandomListNode r=new RandomListNode(h);

        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
    }
}
