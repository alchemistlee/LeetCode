package com.jump.code2021.linkedList;

public class MergeInBetween {


    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;

        ListNode ap=null, bp=null ;
        int i=0;
        while (cur!=null){
            if(i==a-1){
                ap = cur;
            }
            else if(i==b){
                bp = cur;
            }

            cur=cur.next;
            i++;
        }

        cur = list2 ;
        while (cur.next!=null){
            cur = cur.next;
        }

        ap.next = list2;
        cur.next= bp.next;

        return list1;
    }

    public static void main(String[] args){
        ListNode n1 =new ListNode(0);
        ListNode n2 =new ListNode(1);
        ListNode n3 =new ListNode(2);
        ListNode n4 =new ListNode(3);
        ListNode n5 =new ListNode(4);
        ListNode n6 =new ListNode(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;

        ListNode m1 =new ListNode(1000);
        ListNode m2 =new ListNode(1001);
        ListNode m3 =new ListNode(1002);

        m1.next=m2;
        m2.next=m3;

        MergeInBetween m = new MergeInBetween();
        ListNode r = m.mergeInBetween(n1,3,4,m1);

    }
}
