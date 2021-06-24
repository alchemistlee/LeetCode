package com.jump.code2021.tree;

public class LongestUnivaluePath {

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

    public int longestUnivaluePath(TreeNode root) {
        getMaxPath(root);
        return longest-1;
    }

    private int longest=0;

    private int getMaxPath(TreeNode root){
        if(root==null){
            return 0;
        }
        int maxLeft = getMaxPath(root.left);
        int maxRight = getMaxPath(root.right);

        int leftPath =1;
        if(root.left == null || root.val== root.left.val){
            leftPath += maxLeft;
        }

        int rightPath =1;
        if(root.right == null || root.val == root.right.val){
            rightPath +=maxRight;
        }

        longest = Math.max(longest,rightPath+leftPath-1);

        return Math.max(rightPath,leftPath);
    }

    public static void main(String[] args){
        TreeNode r1 = new TreeNode(1);
        TreeNode d11 = new TreeNode(4);
        TreeNode d12 = new TreeNode(5);
        TreeNode d21 = new TreeNode(4);
        TreeNode d22 = new TreeNode(4);
        TreeNode d23 = new TreeNode(5);

        r1.left = d11;
        r1.right=d12;
        d11.left = d21;
        d11.right=d22;
        d12.right=d23;

        LongestUnivaluePath l = new LongestUnivaluePath();
        System.out.println(l.longestUnivaluePath(r1));

    }
}
