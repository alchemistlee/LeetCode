package com.jump.code2021.linkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumComponents {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public int numComponents(ListNode head, int[] nums) {

        int res =0;
        Set<Integer> g=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            g.add(nums[i]);
        }

        ListNode cur = head;

        boolean isInComp = false;

        while (cur!=null){

            if(g.contains(cur.val)){
                if(!isInComp){
                    isInComp=true;
                    res++;
                }
            }
            else{
                isInComp=false;
            }

            cur=cur.next;
        }

        return res;
    }

    public static void main(String[] args){
        ListNode n1 =new ListNode(0);
        ListNode n2 =new ListNode(1);
        ListNode n3 =new ListNode(2);
        ListNode n4 =new ListNode(3);
        ListNode n5 =new ListNode(4);


        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        int[] gg = new int[]{0,3,1,4};

        NumComponents n= new NumComponents();
        int r= n.numComponents(n1,gg);
        System.out.println(r);
    }
}
