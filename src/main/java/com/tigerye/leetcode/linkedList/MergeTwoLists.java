package com.tigerye.leetcode.linkedList;

/**
 * @author : alchemistlee on 2019/8/15
 * @version : 0.0.1
 **/

public class MergeTwoLists {

    static class ListNode{
        int val;
        ListNode next=null;
        ListNode(int v){
            this.val=v;
        }
    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res_head = new ListNode(-1);

        ListNode p_l1 = l1.next;
        ListNode p_l2 = l2.next;
        ListNode p_res = res_head;

        while (p_l1!=null && p_l2!=null){
            if(p_l1.val<=p_l2.val){
                p_res.next = p_l1;
                p_l1 = p_l1.next;
            }
            else{
                p_res.next = p_l2;
                p_l2 = p_l2.next;
            }
            p_res = p_res.next;
        }

        if(p_l1!=null){
            p_res.next = p_l1;
        }
        else{
            p_res.next = p_l2;
        }

        return res_head;
    }

    public static void printListNode(ListNode head){
        ListNode n = head.next;
        while (n!=null){
            System.out.println(n.val);
            n = n.next;
        }
    }


    public static void main(String[] args) {

        ListNode a =new ListNode(-1);
        ListNode b =new ListNode(-1);

        ListNode n1= new ListNode(1);
        ListNode n2= new ListNode(2);
        ListNode n3= new ListNode(4);

        ListNode n4= new ListNode(1);
        ListNode n5= new ListNode(3);
        ListNode n6= new ListNode(4);

        a.next = n1;
        n1.next=n2;
        n2.next=n3;

        b.next = n4;
        n4.next=n5;
        n5.next=n6;

        ListNode c = mergeTwoLists(a,b);
        printListNode(c);

    }

}
