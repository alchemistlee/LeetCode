package com.jump.code2021.tree;

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

    public void flatten(TreeNode root) {
        flatIt(root);
    }

    private TreeNode flatIt(TreeNode root){
        if(root==null){
            return null;
        }

        TreeNode leftRoot = root.left;
        TreeNode rightRoot = root.right;

        TreeNode leftEnd= flatIt(leftRoot);
        TreeNode rightEnd = flatIt(rightRoot);

        TreeNode curEnd = root;
        curEnd.left = null;
        curEnd.right = null;

        if(leftEnd!=null){
            curEnd.right=leftRoot;
            curEnd = leftEnd;
        }
        if(rightEnd!=null){
            curEnd.right=rightRoot;
            curEnd = rightEnd;
        }

        return curEnd;
    }


    public static void main(String[] args){

        TreeNode root = new TreeNode(1);
        TreeNode n11 = new TreeNode(2);
        TreeNode n12 = new TreeNode(5);
        TreeNode n21 = new TreeNode(3);
        TreeNode n22 = new TreeNode(4);
        TreeNode n23 = new TreeNode(6);

        root.left = n11;
        root.right =n12;
        n11.left= n21;
        n11.right = n22;
        n12.right = n23;

        Flatten f = new Flatten();
        f.flatten(root);

        System.out.println(root);
    }
}
