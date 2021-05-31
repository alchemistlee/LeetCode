package com.jump.code2021.tree;

import java.util.ArrayList;
import java.util.List;

public class FindLeaves {

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

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        boolean stat = false;
        while(!stat){
            List<Integer> tmpRes = new ArrayList<>();
            stat = rmLeaves(root, tmpRes);
            res.add(tmpRes);
        }

        return res;

    }

    private boolean rmLeaves(TreeNode root, List<Integer> leafs){
        if(root==null){
            return false;
        }

        if(root.left == null && root.right ==null){
            leafs.add(root.val);
            return true;
        }

        boolean l =  rmLeaves(root.left, leafs);
        boolean r = rmLeaves(root.right, leafs);

        if(l){
            root.left = null;
        }
        if(r){
            root.right = null;
        }
        return false;
    }

    public static void main(String[] args){
        TreeNode r1 = new TreeNode(1);
        TreeNode n11 = new TreeNode(2);
        TreeNode n12 = new TreeNode(3);
        TreeNode n21 = new TreeNode(4);
        TreeNode n22 = new TreeNode(5);
//        TreeNode n23 = new TreeNode(11);
//        TreeNode n31 = new TreeNode(3);
//        TreeNode n32 = new TreeNode(-2);
//        TreeNode n33 = new TreeNode(1);


        r1.left= n11;
        r1.right = n12;
        n11.left = n21;
        n11.right = n22;
//        n12.right = n23;
//        n21.left = n31;
//        n21.right = n32;
//        n22.right = n33;
        FindLeaves f = new FindLeaves();
        List<List<Integer>> r= f.findLeaves(r1);

        System.out.println(r);

    }
}
