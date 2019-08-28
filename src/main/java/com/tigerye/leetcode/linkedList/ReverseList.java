package com.tigerye.leetcode.linkedList;

/**
 * @author : alchemistlee on 2019/8/15
 * @version : 0.0.1
 **/

public class ReverseList {

    static class ListNode{
        int val;
        ListNode next=null;
        ListNode(int v){
            this.val=v;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode p_cur = head.next;
        ListNode p_next = p_cur.next;

        while (p_next!=null){
            if(p_cur==head.next){
                p_cur.next =null;
            }
            ListNode tmp = p_next.next;
            p_next.next= p_cur;
            p_cur=p_next;
            p_next=tmp;
        }

        head.next = p_cur;

        return head;

    }

    public static void printListNode(ListNode head){
        ListNode n = head.next;
        while (n!=null){
            System.out.println(n.val);
            n = n.next;
        }
    }

    public static void main(String[] args) {

        ListNode head =new ListNode(-1);
        ListNode n1= new ListNode(1);
        ListNode n2= new ListNode(2);
        ListNode n3= new ListNode(3);
        ListNode n4= new ListNode(4);
        ListNode n5= new ListNode(5);

        head.next = n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;


        ListNode b = reverseList(head);
        printListNode(b);

    }

}
