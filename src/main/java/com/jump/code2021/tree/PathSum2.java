package com.jump.code2021.tree;

public class PathSum2 {

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

    public int pathSum(TreeNode root, int targetSum) {
        pathIt(root,targetSum,targetSum);
        return this.pathCnt;
    }


    private int pathCnt = 0;
    private void pathIt(TreeNode root, int tarSum, int oriTar){
        if(root ==  null){
            return;
        }

        if(root.val == tarSum){
            this.pathCnt+=1;
        }

        pathIt(root.left, tarSum-root.val,oriTar);
        pathIt(root.right, tarSum-root.val,oriTar);
        pathIt(root.left, oriTar,oriTar);
        pathIt(root.right, oriTar, oriTar);
    }

    public static void main(String[] args){
        TreeNode r1 = new TreeNode(10);
        TreeNode n11 = new TreeNode(5);
        TreeNode n12 = new TreeNode(-3);
        TreeNode n21 = new TreeNode(3);
        TreeNode n22 = new TreeNode(2);
        TreeNode n23 = new TreeNode(11);
        TreeNode n31 = new TreeNode(3);
        TreeNode n32 = new TreeNode(-2);
        TreeNode n33 = new TreeNode(1);


        r1.left= n11;
        r1.right = n12;
        n11.left = n21;
        n11.right = n22;
        n12.right = n23;
        n21.left = n31;
        n21.right = n32;
        n22.right = n33;

        PathSum2 p2 = new PathSum2();
        int res =p2.pathSum(r1,8);
        System.out.println(res);
    }
}
