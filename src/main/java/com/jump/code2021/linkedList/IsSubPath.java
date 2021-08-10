package com.jump.code2021.linkedList;

import java.util.LinkedList;
import java.util.Queue;

public class IsSubPath {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
             this.left = left;
             this.right = right;
          }
    }


    public boolean isSubPath(ListNode head, TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            boolean isFind = findListNode(cur,head);
            if(isFind){
                return true;
            }
            if(cur.left!=null){
                q.offer(cur.left);
            }
            if(cur.right!=null){
                q.offer(cur.right);
            }
        }
        return false;
    }

    private boolean findListNode(TreeNode root, ListNode curNode){
        if(curNode==null){
            return true;
        }

        if(root==null){
            return false;
        }

        if(root.val==curNode.val){
            boolean leftRes = findListNode(root.left,curNode.next);
            boolean rightRes = findListNode(root.right,curNode.next);

            if(leftRes || rightRes){
                return true;
            }

        }
        return false;

    }


    public static void main(String[] args){
        TreeNode r = new TreeNode(1);
        TreeNode rn1 = new TreeNode(4);
        TreeNode rn2 = new TreeNode(4);
        TreeNode rn3 = new TreeNode(2);
        TreeNode rn4 = new TreeNode(2);
        TreeNode rn5 = new TreeNode(1);
        TreeNode rn6 = new TreeNode(6);
        TreeNode rn7 = new TreeNode(8);
        TreeNode rn8 = new TreeNode(1);
        TreeNode rn9 = new TreeNode(3);

        ListNode n1 =new ListNode(4);
        ListNode n2 =new ListNode(2);
        ListNode n3 =new ListNode(8);

        n1.next=n2;
        n2.next=n3;

        r.left=rn1;
        r.right=rn2;
        rn1.right=rn3;
        rn2.left=rn4;
        rn3.left=rn5;
        rn4.left=rn6;
        rn4.right=rn7;
        rn7.left=rn8;
        rn7.right=rn9;

        IsSubPath i = new IsSubPath();
        boolean res =i.isSubPath(n1,r);
        System.out.println(res);
    }
}
