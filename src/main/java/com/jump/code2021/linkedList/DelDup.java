package com.jump.code2021.linkedList;

public class DelDup {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        ListNode cur = head.next;

        if(cur==null){
            return head;
        }

        ListNode n = cur.next;

        while (n!=null){

            if(cur.val==n.val){
                cur = n;
            }
            else{
                if(pre.next==cur){
                    pre = cur;
                    cur = n;
                }
                else{
                    pre.next = n;
                    cur = n;
                }
            }

            n = n.next;
        }

        return head;
    }


    public static void main(String[] args){
        ListNode h1 = new ListNode();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n31 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n41 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        h1.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n31;
        n31.next =n4;
        n4.next=n41;
        n41.next=n5;


        ListNode h2 = new ListNode();
        ListNode nn11 = new ListNode(1);
        ListNode nn12 = new ListNode(1);
        ListNode nn13 = new ListNode(1);
        ListNode nn2 = new ListNode(2);
        ListNode nn3 = new ListNode(3);

        h2.next=nn11;
        nn11.next=nn12;
        nn12.next=nn13;
        nn13.next=nn2;
        nn2.next=nn3;

        DelDup d = new DelDup();
        ListNode res = d.deleteDuplicates(h2);
        System.out.println(res);

    }
}
