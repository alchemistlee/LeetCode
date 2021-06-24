package com.jump.code2021.tree;

import java.util.LinkedList;
import java.util.List;

public class LongestConsecutive2 {

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

    private int longestLen = 0;

    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return longestLen;
    }

    // 0: inr , 1: dcr
    private int[]  longestPath(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }

        int[] res = new int[]{1,1};
        if(root.left!=null){
            int[] leftRes = longestPath(root.left);
            if(root.val+1 == root.left.val){
                res[1] = Math.max(res[1], leftRes[1]+1);
            }
            else if(root.val-1== root.left.val ){
                res[0] = Math.max(res[0],leftRes[0]+1);
            }
        }
        if(root.right!=null){
            int[] rightRes = longestPath(root.right);
            if(root.val+1 == root.right.val){
                res[1] = Math.max(res[1],rightRes[1]+1);
            }
            else if(root.val-1 == root.right.val){
                res[0] = Math.max(res[0],rightRes[0]+1);
            }
        }

        if(longestLen < res[0]+res[1]-1){
            longestLen = res[0]+res[1]-1;
        }

        return res;

    }



    public static void  main(String[] args){
        TreeNode r2 = new TreeNode(2);
        TreeNode d11 = new TreeNode(1);
        TreeNode d12 = new TreeNode(3);
//        TreeNode d21 = new TreeNode(0);
//        TreeNode d22 = new TreeNode(2);
//        TreeNode d23 = new TreeNode(5);
//        TreeNode d24 = new TreeNode(7);
//        TreeNode d31 = new TreeNode(3);
//        TreeNode d32 = new TreeNode(8);

        r2.left = d11;
        r2.right = d12;
//        d11.left = d21;

        LongestConsecutive2 l= new LongestConsecutive2();
        System.out.println(l.longestConsecutive(r2));

    }
}
