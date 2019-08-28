package com.tigerye.leetcode.linkedList;

import java.util.List;

/**
 * @author : alchemistlee on 2019/8/14
 * @version : 0.0.1
 **/


public class DeleteNode {


    public static class ListNode{
        int val;
        ListNode next=null;
        ListNode(int v){
            this.val=v;
        }
    }


    public static void deleteNode(ListNode head, ListNode node) {
        ListNode p_last = head;
        ListNode p_cur = head.next;
        while (p_cur != null){
            if(p_cur.val==node.val){
                p_last.next = p_cur.next;
                break;
            }
            p_last = p_cur;
            p_cur = p_cur.next;
        }
        //print

        ListNode cur = head.next;
        while (cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }

    }

    public static void main(String[] args) {
        ListNode head =new ListNode(-1);
        ListNode n1= new ListNode(4);
        ListNode n2= new ListNode(5);
        ListNode n3= new ListNode(1);
        ListNode n4= new ListNode(9);

        head.next = n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;

        ListNode a = new ListNode(5);

        deleteNode(head,a);


    }
}
