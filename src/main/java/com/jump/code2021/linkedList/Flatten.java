package com.jump.code2021.linkedList;

public class Flatten {

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

    TreeNode head;
    TreeNode cur;

    public void flatten(TreeNode root) {
        head = new TreeNode();
        cur = head;
        flat1(root);
    }

    private void flat1(TreeNode root){
        if(root==null){
            return;
        }

        TreeNode left = root.left;
        TreeNode right =root.right;

        cur.right = root;
        root.left = null;
        root.right = null;
        cur = root;

        flat1(left);
        flat1(right);

    }

    public static void main(String[] args){
        TreeNode root= new TreeNode(1);
        TreeNode n1= new TreeNode(2);
        TreeNode n2= new TreeNode(5);
        TreeNode n3= new TreeNode(3);
        TreeNode n4= new TreeNode(4);
        TreeNode n5= new TreeNode(6);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right =n4;
        n2.right=n5;

        Flatten f =new Flatten();
        f.flatten(root);
        System.out.println(f.head);
    }
}
