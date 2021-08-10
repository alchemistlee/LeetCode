package com.jump.code2021.linkedList;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumSublists {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;

        Map<Integer,ListNode> m = new HashMap<>();

        int sumVal=0;
        ListNode cur = dummy;

        while (cur!=null){
            sumVal+=cur.val;
            m.put(sumVal,cur);

            cur=cur.next;
        }

        cur = dummy;
        sumVal =0;

        while (cur!=null){
            sumVal+=cur.val;
            cur.next = m.get(sumVal).next;

            cur=cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode n1 =new ListNode(1);
        ListNode n2 =new ListNode(2);
        ListNode n3 =new ListNode(3);
        ListNode n4 =new ListNode(-3);
        ListNode n5 =new ListNode(4);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;


        RemoveZeroSumSublists r = new RemoveZeroSumSublists();
        ListNode res = r.removeZeroSumSublists(n1);

    }
}
