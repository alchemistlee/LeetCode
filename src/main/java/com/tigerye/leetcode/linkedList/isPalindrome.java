package com.tigerye.leetcode.linkedList;

/**
 * @author : alchemistlee on 2019/8/15
 * @version : 0.0.1
 **/

public class isPalindrome {

    static class ListNode{
        int val;
        ListNode next=null;
        ListNode(int v){
            this.val=v;
        }
    }

    static boolean isPalindromeLinked(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head.next;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }

        if(fast!=null){
            slow = slow.next; //指向较短的一支
        }

        //反转后半部分
        ListNode p_cur = slow;
        ListNode p_next = slow.next;
        slow.next =null;

        while (p_next!=null){
            ListNode tmp = p_next.next;
            p_next.next = p_cur;
            p_cur=p_next;
            p_next = tmp;
        }
        ListNode posListNode = head.next;
        while (p_cur!=null){
            if(posListNode.val!=p_cur.val){
                return false;
            }
            p_cur=p_cur.next;
            posListNode = posListNode.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode a =new ListNode(-1);

        ListNode n1= new ListNode(1);
        ListNode n2= new ListNode(2);
//        ListNode n3= new ListNode(3);
//        ListNode n4= new ListNode(1);

        a.next = n1;
        n1.next=n2;
//        n2.next=n3;
//        n3.next=n4;

        System.out.println(isPalindromeLinked(a));
    }

}
