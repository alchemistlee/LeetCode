package com.jump.code2021.linkedList;

import java.util.ArrayList;
import java.util.List;

public class DetectCycle {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    public ListNode detectCycle(ListNode head) {



        ListNode fast=head;
        ListNode slow=head;

        boolean isCycle = false;

        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;

            if(fast == slow){
                isCycle =true;
                break;
            }
        }

        if(!isCycle){
            return null;
        }

        slow = head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
//        ListNode n5 = new ListNode(9);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n2;

        DetectCycle d= new DetectCycle();
        ListNode res = d.detectCycle(n1);

        System.out.println(res);

//        List<String>  a = new ArrayList<>();
//        a.add("sss");
//        a.add("ddd");
//
//        String[] b= a.toArray(new String[0]);


    }
}
