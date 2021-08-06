package com.jump.code2021.linkedList;

public class SplitListToParts {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {

        int n = 0;
        ListNode cur = head;

        while (cur!=null){
            cur=cur.next;
            n++;
        }

        int basicLen= n/k;
        int leftLen = n%k;

        int[] partLen = new int[k];
        for(int i=0;i<k;i++){
            partLen[i]=basicLen;
        }

        for(int j=leftLen,f=0;j>0;j--,f++){
            partLen[f]+=1;
        }

        ListNode[] res = new ListNode[k];

        cur = head;

        for(int i=0;i<k;i++){
            ListNode tmpH = cur;
            for(int j=0; cur!=null && j<partLen[i] ;j++){
                if(j==partLen[i]-1){
                    ListNode tmpE = cur;
                    cur=cur.next;
                    tmpE.next =null;
                }
                else{
                    cur = cur.next;
                }
            }
            res[i] = tmpH;
        }

        return res;

    }




    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(10);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=n8;
        n8.next=n9;
        n9.next=n10;

        SplitListToParts s =new SplitListToParts();
        ListNode[] r = s.splitListToParts(n1,3);

    }
}
