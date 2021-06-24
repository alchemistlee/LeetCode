package com.jump.code2021.tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {

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

    private void findLeftBound(TreeNode root, boolean isBound, List<Integer> bounds, List<Integer> leafs){
        if(root==null){
            return;
        }

        if(root.left==null && root.right==null){
            leafs.add(root.val);
            return;
        }

        boolean isLeftBound = false;
        boolean isRightBound = false;

        if(isBound) {
            bounds.add(root.val);

            if (root.left != null) {
                isLeftBound = true;
            } else if (root.right != null) {
                isRightBound = true;
            }
        }

        findLeftBound(root.left, isLeftBound, bounds, leafs);
        findLeftBound(root.right, isRightBound, bounds, leafs);

    }

    private void findRightBound(TreeNode root, boolean isBound, List<Integer> bounds, List<Integer> leafs){
        if(root==null){
            return;
        }

        if(root.left==null && root.right==null){
            leafs.add(root.val);
            return;
        }

        boolean isLeftBound = false;
        boolean isRightBound = false;

        if(isBound) {
            bounds.add(root.val);

            if (root.right != null) {
                isRightBound = true;
            } else if (root.left != null) {
                isLeftBound = true;
            }
        }

        findLeftBound(root.left, isLeftBound, bounds, leafs);
        findLeftBound(root.right, isRightBound, bounds, leafs);

    }



    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> leftBound = new ArrayList<>();
        List<Integer> rightBound = new ArrayList<>();
        List<Integer> leftLeafs = new ArrayList<>();
        List<Integer> rightLeafs = new ArrayList<>();
        if(root!=null) {
            leftBound.add(root.val);

            findLeftBound(root.left, true, leftBound, leftLeafs);
            findRightBound(root.right, true, rightBound, rightLeafs);

        }

        List<Integer> res = new ArrayList<>();
        res.addAll(leftBound);
        res.addAll(leftLeafs);
        res.addAll(rightLeafs);

        for(int j=rightBound.size()-1;j>=0;j--){
            res.add(rightBound.get(j));
        }
        return res;
    }

    public static void main(String[] args){
        TreeNode r2 = new TreeNode(1);
        TreeNode d11 = new TreeNode(2);
//        TreeNode d12 = new TreeNode(6);
//        TreeNode d21 = new TreeNode(0);
//        TreeNode d22 = new TreeNode(2);
//        TreeNode d23 = new TreeNode(5);
//        TreeNode d24 = new TreeNode(7);
        TreeNode d31 = new TreeNode(3);
        TreeNode d32 = new TreeNode(4);

        r2.right = d11;
        d11.left = d31;
        d11.right = d32;

        BoundaryOfBinaryTree b = new BoundaryOfBinaryTree();
        List<Integer> r= b.boundaryOfBinaryTree(r2);
        System.out.println(r);
    }
}
