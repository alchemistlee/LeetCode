package com.jump.code2021.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildTree {


     public class TreeNode {
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


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre1 = new ArrayList<>();
        List<Integer> in1 = new ArrayList<>();
        for(int i=0;i<preorder.length;i++){
            pre1.add(preorder[i]);
        }
        for(int j=0;j<inorder.length;j++){
            in1.add(inorder[j]);
        }

        return buildIt(pre1, in1);
    }

    private TreeNode buildIt(List<Integer> preOrd, List<Integer> inOrd){
         if(preOrd==null || preOrd.size()<1){
             return null;
         }

         TreeNode root = new TreeNode(preOrd.get(0));

         int rootIdx = inOrd.indexOf(preOrd.get(0));

         List<Integer> leftIn =  inOrd.subList(0,rootIdx);
         List<Integer> rightIn = inOrd.subList(rootIdx+1,inOrd.size());

         List<Integer> leftPre = preOrd.subList(1,1+leftIn.size());
         List<Integer> rightPre = preOrd.subList(1+leftIn.size(),preOrd.size());

         root.left = buildIt(leftPre, leftIn);
         root.right = buildIt(rightPre, rightIn);

         return root;
    }


    public static void main(String[] args){

         int[] preorder = new int[]{3,9,20,15,7};
         int[] inorder = new int[]{9,3,15,20,7};

         BuildTree t = new BuildTree();
         TreeNode r = t.buildTree(preorder, inorder);
    }
}
