package com.jump.code2021.tree;

import java.util.List;

public class ValidBST {

    static class TreeNode {

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


    public boolean isValidBST(TreeNode root) {
        return  validIt(root,null,null);
    }

    private boolean validIt(TreeNode root, TreeNode min, TreeNode max){
        if(root == null){
            return true;
        }

        if(min!=null && min.val>=root.val){
            return false;
        }
        if(max!=null && max.val<=root.val){
            return false;
        }

        boolean lRes = validIt(root.left, min, root);
        boolean rRes = validIt(root.right, root, max);

        return  lRes && rRes;
    }

    public double log2(double N) {
        return Math.log(N)/Math.log(2);//Math.log的底为e
    }

//    public TreeNode buildIt1(List<Integer> input){
//        TreeNode res = null;
//        int h = new Double(log2(input.size()+1)).intValue();
//        for(int i=0;i<h;i++){
//            int nIdx = new Double(Math.pow(2,i)-1).intValue();
//            int n2Idx = new Double(Math.pow(2,i+1)-1).intValue();
//            res.val = input.get(nIdx).intValue();
//
//            for(int j=nIdx+1;j<n2Idx;j++){
//                res
//            }
//        }
//    }

    public static void main(String[] args){
        //构造
        TreeNode root = new TreeNode(2);
        TreeNode l = new TreeNode(1);
        TreeNode r = new TreeNode(3);

        root.left = l;
        root.right =r;



        ValidBST v = new ValidBST();
        System.out.println(v.isValidBST(root));
    }
}
