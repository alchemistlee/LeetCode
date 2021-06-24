package com.jump.code2021.tree;

public class ConMaxBinTree {

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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode r = buildMaxBinTree(nums,0,nums.length-1);
        return r;
    }


    private TreeNode buildMaxBinTree(int[] nums, int start, int end){
        if(start>end){
            return null;
        }

        int maxIdx = start;
        int maxVal = nums[start];
        for(int i=start;i<=end;i++){
            if(nums[i]>maxVal){
                maxVal = nums[i];
                maxIdx = i;
            }
        }

        TreeNode cur = new TreeNode(maxVal);

        TreeNode l = buildMaxBinTree(nums,start,maxIdx-1);
        TreeNode r = buildMaxBinTree(nums,maxIdx+1,end);

        cur.left =l;
        cur.right=r;

        return cur;
    }

    public static void main(String[] args){
        int[] n= new int[]{3,2,1,6,0,5};
        ConMaxBinTree c = new ConMaxBinTree();
        TreeNode r = c.constructMaximumBinaryTree(n);
        System.out.println(r);
    }
}
