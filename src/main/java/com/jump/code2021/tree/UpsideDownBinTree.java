package com.jump.code2021.tree;

public class UpsideDownBinTree {

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

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null){
            return null;
        }

        TreeNode newRoot =upsideDownBinaryTree(root.left);

        if(newRoot==null){
            newRoot = root;
            return newRoot;
        }

        TreeNode curRight = root.right;
        root.left.left = curRight;
        root.left.right= root;
        return newRoot;
    }

    public static void main(String[] args){

        TreeNode r1 = new TreeNode(1);
        TreeNode n11 = new TreeNode(2);
        TreeNode n12 = new TreeNode(3);
        TreeNode n31 = new TreeNode(4);
        TreeNode n32 = new TreeNode(5);
        TreeNode n33 = new TreeNode(4);

        r1.left=n11;
        r1.right =n12;
        n11.left=n31;
        n11.right=n32;


        UpsideDownBinTree u = new UpsideDownBinTree();
        TreeNode res =  u.upsideDownBinaryTree(r1);
        System.out.println(res);
    }
}
