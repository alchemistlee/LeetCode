package com.jump.leetcode.linkedList;

/**
 * @author : alchemistlee on 2019/8/15
 * @version : 0.0.1
 **/

public class HasCycle {

    static class ListNode{
        int val;
        ListNode next=null;
        ListNode(int v){
            this.val=v;
        }
    }

    static boolean hasCycle(ListNode head) {
        ListNode slow = head.next;
        ListNode fast = head.next;
        int i=0;
        while (fast!=null && fast.next!=null){
            if(i==0){
                slow = slow.next;
                fast = fast.next.next;
                i++;
            }
            else if(slow==fast){
                return true;
            }
            else{
                slow=slow.next;
                fast=fast.next.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ListNode a =new ListNode(-1);

        ListNode n1= new ListNode(3);
        ListNode n2= new ListNode(2);
        ListNode n3= new ListNode(0);
        ListNode n4= new ListNode(4);

        a.next = n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
//        n4.next=n2;

        System.out.println(hasCycle(a));

    }

}
