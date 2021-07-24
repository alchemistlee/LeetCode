package com.jump.code2021.linkedList;

import java.util.HashMap;
import java.util.Map;

public class SortedListToBST {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    private static class TreeNode {

        int val;
        TreeNode left=null;
        TreeNode right=null;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode sortedListToBST(ListNode head) {
        return buildBst(head.next);
    }

    private TreeNode buildBst(ListNode h){
        if(h==null){
            return null;
        }

        Map<Integer,ListNode> tmp = new HashMap<>();
        ListNode cur = h;
        int i=1;
        while (cur!=null){
            tmp.put(i,cur);
            i++;
            cur=cur.next;
        }

        int len = tmp.size();
        int mid = 1+ (len-1)/2;
        ListNode rootNode = tmp.get(mid);
        ListNode preNode = tmp.get(mid-1);
        ListNode nextNode = rootNode.next;


        TreeNode root = new TreeNode(rootNode.val);
        if(preNode!=null) {
            preNode.next =null;
            root.left = buildBst(h);
        }
        root.right = buildBst(nextNode);

        return root;

    }

    public static void main(String[] args){
        ListNode h1 = new ListNode();
        ListNode n1 = new ListNode(-10);
        ListNode n2 = new ListNode(-3);
        ListNode n3 = new ListNode(0);
        ListNode n31 = new ListNode(5);
        ListNode n4 = new ListNode(9);

        h1.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n31;
        n31.next=n4;

        SortedListToBST s = new SortedListToBST();
        TreeNode res = s.sortedListToBST(h1);

        System.out.println(res);

    }
}
