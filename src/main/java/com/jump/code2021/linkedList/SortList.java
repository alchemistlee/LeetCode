package com.jump.code2021.linkedList;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

public class SortList {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {

        int subLen = 1;
        int allLen =0;

        ListNode cur = head;
        while (cur!=null){
            allLen ++;
            cur=cur.next;
        }

        ListNode realHead = head;

        while (subLen<allLen){
            ListNode c1 =  realHead;
            ListNode pre1 = null;
            while (c1!=null){
                ListNode lh = c1;
                ListNode c2 =c1;
                ListNode pre2 = null;

                for(int i=0;i<subLen && c2!=null;i++){
                    pre2 = c2;
                    c2=c2.next;
                }
                pre2.next = null;

                ListNode rh = c2;
                pre2=null;
                for(int i=0;i<subLen && c2!=null;i++){
                    pre2=c2;
                    c2=c2.next;
                }
                if(pre2!=null){
                    pre2.next =null;
                }
                c1=c2;

                List<ListNode> res = merge2(lh,rh);
                if(pre1==null){
                    realHead = res.get(0);
                }
                else{
                    pre1.next = res.get(0);
                }
                pre1 = res.get(1);

            }
            subLen*=2;
        }

        return realHead;
    }

    private List<ListNode> merge2(ListNode lHead, ListNode rHead){
        List<ListNode> res = new ArrayList<>();

        ListNode lcur=lHead;
        ListNode rcur=rHead;


        ListNode realHead = null;
        ListNode realTail = null;

        while (lcur!=null && rcur!=null){
            if(lcur.val< rcur.val){
                if(realHead==null){
                    realHead=lcur;
                    realTail=lcur;
                }
                else{
                    realTail.next = lcur;
                    realTail=lcur;
                }

                lcur =lcur.next;
                realTail.next = null;
            }
            else{
                if(realHead==null){
                    realHead=rcur;
                    realTail = rcur;
                }
                else{
                    realTail.next=rcur;
                    realTail = rcur;
                }

                rcur=rcur.next;
                realTail.next=null;
            }
        }

        if(lcur!=null){
            if(realTail!=null){
                realTail.next = lcur;
                while (lcur!=null){
                    realTail = lcur;
                    lcur=lcur.next;
                }
            }
            else{
                realHead = lHead;
                ListNode c1 = lHead;
                while (c1!=null){
                    realTail=c1;
                    c1=c1.next;
                }
            }
        }
        else if(rcur!=null){
            if(realTail!=null) {
                realTail.next = rcur;
                while (rcur!=null){
                    realTail = rcur;
                    rcur=rcur.next;
                }
            }
            else{
                realHead = rHead;
                ListNode c1 = rHead;
                while (c1!=null){
                    realTail=c1;
                    c1=c1.next;
                }
            }
        }

        res.add(realHead);
        res.add(realTail);

        return res;
    }


    public static void main(String[] args){
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;

        SortList s =new SortList();
        ListNode res = s.sortList(n1);

    }
}
