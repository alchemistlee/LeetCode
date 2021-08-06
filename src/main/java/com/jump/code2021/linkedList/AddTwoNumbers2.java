package com.jump.code2021.linkedList;

public class AddTwoNumbers2 {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverseIt(l1);
        ListNode r2 = reverseIt(l2);

        ListNode res = null;

        ListNode c1=r1;
        ListNode c2=r2;
        ListNode c3= null;

        int upNum=0;

        while (c1!=null && c2!=null){
            int sumRes = c1.val+c2.val+upNum;
            upNum = sumRes/10;
            int newVal = sumRes%10;
            ListNode added = new ListNode(newVal);

            if(res==null){
                res= added;
                c3= added;
            }
            else{
                c3.next=added;
                c3= c3.next;
            }
            c1=c1.next;
            c2=c2.next;

        }

        while (c1!=null){
            int sum1 = c1.val+upNum;
            upNum = sum1/10;
            int tmp = sum1%10;
            ListNode tmpNode = new ListNode(tmp);

            if(res==null){
                res = tmpNode;
                c3 = tmpNode;
            }
            else{
                c3.next=tmpNode;
                c3=c3.next;
            }
            c1=c1.next;
        }

        while (c2!=null){
            int sum2 = c2.val+upNum;
            upNum = sum2/10;
            int tmp = sum2%10;
            ListNode tmpNode = new ListNode(tmp);

            if(res==null){
                res = tmpNode;
                c3 = tmpNode;
            }
            else{
                c3.next=tmpNode;
                c3=c3.next;
            }
            c2=c2.next;
        }



        return reverseIt(res);

    }

    private ListNode reverseIt(ListNode h){
        if(h.next==null){
            return h;
        }

        ListNode r= reverseIt(h.next);
        h.next.next=h;
        h.next = null;
        return r;
    }

    public static void  main(String[] args){
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(3);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;

        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(4);

        m1.next=m2;
        m2.next=m3;

        AddTwoNumbers2 a=new AddTwoNumbers2();
        ListNode r= a.addTwoNumbers(n1,m1);

    }
}
