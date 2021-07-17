package com.jump.code2021.linkedList;

public class AddTwoNumbers {

    static private class ListNode {
        int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addIt(l1,l2,0);
    }

    private ListNode addIt(ListNode l1, ListNode l2, int extraNum){
        if(l1==null && l2==null){
            if(extraNum==0){
                return null;
            }
            else{
                ListNode t = new ListNode(extraNum);
                return t;
            }
        }

        int v1 = l1==null? 0 : l1.val;
        int v2 = l2==null? 0 : l2.val;

        int last = v1+v2+extraNum;

        int upNum = last/10;
        int curNum = last%10;

        ListNode newNode = new ListNode(curNum);

        ListNode next1 = l1==null? null : l1.next;
        ListNode next2 = l2==null? null : l2.next;

        newNode.next = addIt(next1, next2, upNum);

        return newNode;
    }


    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);

        l1.next=l12;
        l12.next=l13;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);

        l2.next = l22;
        l22.next =l23;

        AddTwoNumbers a = new AddTwoNumbers();
        ListNode l3 = a.addTwoNumbers(l1,l2);

        System.out.println(l3);

    }

}
