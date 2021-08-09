package com.jump.code2021.linkedList;

import java.util.ArrayList;
import java.util.List;

public class NextLargerNodes {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int[] nextLargerNodes(ListNode head) {

        List<Integer> res = new ArrayList<>();

        ListNode cur = head;

        while (cur!=null){

            int tmp = lastAndBigger(cur.val,  cur.next);
            res.add(tmp);

            cur = cur.next;
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    private int lastAndBigger(int tar, ListNode h){
        if(h==null){
            return 0;
        }
        if(h.val>tar){
            return h.val;
        }
        return lastAndBigger(tar, h.next);
    }

    public static void main(String[] args){
        ListNode n1 =new ListNode(2);
        ListNode n2 =new ListNode(7);
        ListNode n3 =new ListNode(4);
        ListNode n4 =new ListNode(3);
        ListNode n5 =new ListNode(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        NextLargerNodes n = new NextLargerNodes();

        int[] r = n.nextLargerNodes(n1);

        System.out.println(r);

    }
}
