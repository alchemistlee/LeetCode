package com.jump.code2021.linkedList;

import java.util.List;

public class InsertSortList {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode cur = head.next;
        ListNode sortedHead = head;
        sortedHead.next = null;

        while (cur!=null){
            ListNode next = cur.next;
            cur.next = null;
            sortedHead = rightPos(sortedHead,  cur);
            cur = next;
        }

        return sortedHead;
    }

    private ListNode rightPos(ListNode h, ListNode addNode){

        if(h.val> addNode.val){
            addNode.next = h;
            return addNode;
        }


        ListNode cur = h.next;
        ListNode pre = h;

        while (cur!=null){
            if(cur.val> addNode.val){
                addNode.next = cur;
                pre.next = addNode;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        if(cur==null){
            pre.next = addNode;
        }

        return h;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;

        InsertSortList i = new InsertSortList();
        ListNode r = i.insertionSortList(n1);

    }
}
