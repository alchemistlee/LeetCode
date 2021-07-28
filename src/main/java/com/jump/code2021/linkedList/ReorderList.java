package com.jump.code2021.linkedList;

public class ReorderList {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    public void reorderList(ListNode head) {

        if(head==null||head.next==null){
            return;
        }

        ListNode fast = head.next;
        ListNode slow = head.next;
        ListNode pre =head.next;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        ListNode l1 = head.next;
        pre.next =null;

        ListNode l2 = reverse(slow);

        if(l2==l1){
            return;
        }

        ListNode l3 =head;
        ListNode cur1 = l1;
        ListNode cur2 = l2;


        while(cur1!=null && cur2!=null){
            l3.next = cur2;
            l3= l3.next;
            cur2= cur2.next;

            l3.next = cur1;
            l3=l3.next;
            cur1=cur1.next;
        }

        if(cur1!=null){
            l3.next = cur1;
        }
        else{
            l3.next= cur2;
        }

    }

    private ListNode reverse(ListNode h){
        if(h.next==null){
            return h;
        }

        ListNode r = reverse(h.next);
        h.next.next = h;
        h.next = null;
        return r;
    }



    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(9);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
//        n4.next=n2;

        ReorderList r=new ReorderList();
        r.reorderList(n1);
        System.out.println(n1);

    }
}
