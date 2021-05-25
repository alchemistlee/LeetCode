package com.jump.code2021.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        p.add(root.val);
        pathIt(root,targetSum,p, res);
        return res;
    }

    public void pathIt(TreeNode root, int target, List<Integer> path, List<List<Integer>> res){
        if(root.left ==null && root.right == null){
            if(root.val == target) {
//                path.add(root.val);
                res.add(path);
            }
            return;
        }

        if(root.left!=null){
            List<Integer> curPath = new ArrayList<>();
            curPath.addAll(path);
            curPath.add(root.left.val);
            pathIt(root.left,target-root.val, curPath, res);
        }
        if(root.right!=null){
            List<Integer> curPath = new ArrayList<>();
            curPath.addAll(path);
            curPath.add(root.right.val);
            pathIt(root.right,target-root.val, curPath, res);
        }

    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode n11 = new TreeNode(4);
        TreeNode n12 = new TreeNode(8);
        TreeNode n31 = new TreeNode(11);
        TreeNode n32 = new TreeNode(13);
        TreeNode n33 = new TreeNode(4);
        TreeNode n41 = new TreeNode(7);
        TreeNode n42 = new TreeNode(2);
        TreeNode n43 = new TreeNode(5);
        TreeNode n44 = new TreeNode(1);

        root.left=n11;
        root.right=n12;
        n11.left =n31;
        n12.left=n32;
        n12.right=n33;
        n31.left=n41;
        n31.right = n42;
        n33.left = n43;
        n33.right = n44;


        TreeNode root1 = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);

        root1.left=n1;
        root1.right=n2;




        PathSum p = new PathSum();
        List<List<Integer>> r = p.pathSum(root1,5);
        System.out.println(r);

    }
}
