package com.jump.code2021.linkedList;

public class ReverseBetween {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head.next;

        int i=1;

        ListNode pre1 = null;
        ListNode end = null;
        while (cur!=null){

            if(i >= left && i<= right) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            else if(i==left-1) {
                pre1 = cur;
                end = cur.next;
                cur = cur.next;
            }
            else if(i==right+1){
                pre1.next = pre;
                end.next = cur;
                cur=cur.next;
            }
            else{
                cur=cur.next;
            }
            i++;
        }

        if(left==1){
            head.next = pre;
        }

        return head;

    }

    //递归版本
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        return reverseIt(head.next, left-1, right-1,null);
    }

    private ListNode reverseIt(ListNode h, int leftDis, int rightDis, ListNode revTail){
        if(rightDis==0){
            revTail.next = h.next;
            return h;
        }

        if(leftDis>1){
            reverseIt(h.next, leftDis-1, rightDis-1,null);
            return h;
        }
        else if(leftDis==1){
            h.next = reverseIt(h.next, leftDis-1, rightDis-1,null);
            return h;
        }
        else if(leftDis==0){
            ListNode t2 = h.next;
            ListNode tmp = reverseIt(t2, leftDis-1, rightDis-1, h);
            t2.next = h;
            return tmp;
        }
        else{
            ListNode tmp = reverseIt(h.next, leftDis-1, rightDis-1, revTail);
            h.next.next = h;
            return tmp;
        }

    }

    //递归版本2
    public ListNode reverseBetween3(ListNode head, int left, int right) {
        if(left==1){
            return reverseTopN(head, right);
        }

        head.next = reverseBetween3(head.next, left-1,right-1);
        return head;
    }

    private ListNode succNode;

    private ListNode reverseTopN(ListNode h, int n){
        if(n==1){
            succNode = h.next;
            return h;
        }

        ListNode res = reverseTopN(h.next, n-1);
        h.next.next = h;
        h.next = succNode;
        return res;
    }



    public static void main(String[] args){
        ListNode h1 = new ListNode();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n31 = new ListNode(4);
        ListNode n4 = new ListNode(5);

        h1.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n31;
        n31.next=n4;

        ReverseBetween r1 = new ReverseBetween();
//        ListNode res = r1.reverseBetween(h1,2,4);
//        ListNode res = r1.reverseBetween2(h1,2,4);
        ListNode res = r1.reverseBetween3(h1.next,2,4);
        System.out.println(res);
    }
}
