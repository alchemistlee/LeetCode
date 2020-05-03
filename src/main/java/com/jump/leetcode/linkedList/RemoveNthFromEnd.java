package com.jump.leetcode.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : alchemistlee on 2019/8/15
 * @version : 0.0.1
 **/

public class RemoveNthFromEnd {

    public static class ListNode{
        int val;
        ListNode next=null;
        ListNode(int v){
            this.val=v;
        }
    }

    //version-1
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> tmpNodes = new ArrayList<>();

        ListNode nn = head.next;
        while (nn!=null){
            tmpNodes.add(nn);
            nn = nn.next;
        }

        int tarIdx = tmpNodes.size()-n;
        ListNode tarNode = tmpNodes.get(tarIdx);
        ListNode preNode = tmpNodes.get(tarIdx-1);
        preNode.next=tarNode.next;

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

        ListNode b = removeNthFromEnd(head,2);
        printListNode(b);
    }

}
