package com.tigerye.leetcode.bitree;

/**
 * @author : alchemistlee on 2019/8/16
 * @version : 0.0.1
 **/

public class SortedArrayToBST {

    static  class TreeNode {
        int val;
        TreeNode left=null;
        TreeNode right=null;
        TreeNode(int x) { val = x; }
    }

    static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        else if(nums.length==1){
            TreeNode tmp = new TreeNode(nums[0]);
            tmp.left = null;
            tmp.right = null;
            return tmp;
        }

        int center_idx =  nums.length/2;
        int left_len = center_idx;
        int right_len = nums.length - left_len-1;

        int[] left_nums = new int[left_len];
        int[] right_nums = new int[right_len];

        for(int i=0,k=0;i<nums.length;i++){
            if(i<center_idx){
                left_nums[k]= nums[i];
                k++;
            }
            else if(i==center_idx){
                k=0;
            }
            else{
                right_nums[k]=nums[i];
                k++;
            }
        }

        TreeNode res = new TreeNode(nums[center_idx]);
        res.left = sortedArrayToBST(left_nums);
        res.right = sortedArrayToBST(right_nums);

        return res;
    }

    static void printTree(TreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.val);
        printTree(node.left);
        printTree(node.right);
    }


    public static void main(String[] args) {

        int[] a = {-10,-3,0,5,9};
        TreeNode b = sortedArrayToBST(a);
        printTree(b);

    }

}
