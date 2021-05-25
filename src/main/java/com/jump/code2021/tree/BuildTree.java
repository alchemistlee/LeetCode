package com.jump.code2021.tree;

import java.util.ArrayList;
import java.util.List;

public class BuildTree {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length==0||inorder.length==0){
            return null;
        }

        return buildIt(preorder,inorder,0,preorder.length-1,0,inorder.length-1);

    }





    private TreeNode buildIt(int[] preorder , int[] inorder, int preSta , int preEnd, int inSta, int inEnd ){
        if(preSta>preEnd || inSta>inEnd){
            return null;
        }



        int root_val = preorder[preSta];
        TreeNode root = new TreeNode();
        root.val = root_val;
        int rootIdx = -1;

        for(int i=inSta;i<=inEnd;i++){
            if(inorder[i]==root_val){
                rootIdx = i;
                break;
            }
        }

        int leftSize = rootIdx-inSta;
//        int rightSize = inEnd-rootIdx;
        root.left = buildIt(preorder,inorder,preSta+1,preSta+leftSize,inSta,rootIdx-1);
        root.right = buildIt(preorder,inorder,preSta+leftSize+1,preEnd,rootIdx+1,inEnd);
        return root;
    }

    public static void main(String[] args){
        int[] pre = new int[]{3,9,20,15,7};
        int[] in = new int[]{9,3,15,20,7};

        BuildTree b = new BuildTree();
        TreeNode r= b.buildTree(pre, in);
        System.out.println(r);

    }
}
