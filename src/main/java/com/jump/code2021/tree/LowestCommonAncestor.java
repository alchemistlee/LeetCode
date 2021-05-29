package com.jump.code2021.tree;

import sun.jvm.hotspot.types.basic.BasicOopField;

public class LowestCommonAncestor {

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


    private boolean isExist(TreeNode root, TreeNode tar){
        if(root==null){
            return false;
        }

        if(root.val == tar.val){
            return true;
        }
        boolean l = isExist(root.left,tar) || isExist(root.right,tar);
        return l;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        boolean leftExistP = isExist(root.left, p);
        boolean leftExistQ = isExist(root.left,q);
        boolean rightExistQ =  isExist(root.right,q);
        boolean rightExistP = isExist(root.right,p);
        TreeNode res = null;
        if(leftExistP  && leftExistQ){
            res = lowestCommonAncestor(root.left,p,q);
        }
        else if(rightExistP && rightExistQ){
            res =lowestCommonAncestor(root.right, p, q);
        }
        else if(leftExistP && rightExistQ){
            res = root;
        }
        else if(leftExistQ && rightExistP){
            res = root;
        }
        else if(leftExistP && root.val == q.val){
            res = root;
        }
        else if(rightExistP && root.val == q.val){
            res = root;
        }
        else if(leftExistQ && root.val == p.val){
            res = root;
        }
        else if(rightExistQ && root.val == p.val){
            res = root;
        }

        return res;
    }

    public static void main(String[] args){

        TreeNode r1 = new TreeNode(3);
        TreeNode n11 = new TreeNode(5);
        TreeNode n12 = new TreeNode(1);
        TreeNode n21 = new TreeNode(6);
        TreeNode n22 = new TreeNode(2);
        TreeNode n23 = new TreeNode(0);
        TreeNode n24 = new TreeNode(8);
        TreeNode n31 = new TreeNode(7);
        TreeNode n32 = new TreeNode(4);

        r1.left=n11;
        r1.right =n12;
        n11.left=n21;
        n11.right=n22;
        n12.left = n23;
        n12.right = n24;
        n22.left = n31;
        n22.right = n32;

        LowestCommonAncestor lca = new LowestCommonAncestor();
        TreeNode r = lca.lowestCommonAncestor(r1,n11,n23);
        System.out.println(r.val);
    }
}
