package com.jump.code2021.tree;

public class LargestBSTSubtree {

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

    public int largestBSTSubtree(TreeNode root) {
        isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.maxBSTSize;
    }

    private int maxBSTSize = 0;

    private int isValidBST(TreeNode root, int min, int max){
        if(root==null){
            return 0;
        }


        int l = isValidBST(root.left, min , root.val);
        int r = isValidBST(root.right, root.val, max);


        if(root.val>=max || root.val<=  min ){
            return -1;
        }

        int tmpSize= -1;
        if(l>=0 && r>=0){
            tmpSize=l+r+1;
            if(tmpSize>this.maxBSTSize){
                this.maxBSTSize = tmpSize;
            }
        }

        return tmpSize;

    }

    public static void main(String[] args){

        TreeNode r1 = new TreeNode(10);
        TreeNode n11 = new TreeNode(5);
        TreeNode n12 = new TreeNode(15);
        TreeNode n21 = new TreeNode(1);
        TreeNode n22 = new TreeNode(8);
        TreeNode n23 = new TreeNode(7);

        r1.left= n11;
        r1.right = n12;
        n11.left = n21;
        n11.right = n22;
        n12.right = n23;

        LargestBSTSubtree l = new LargestBSTSubtree();
        int r=  l.largestBSTSubtree(r1);
        System.out.println(r);

    }
}
