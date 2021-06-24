package com.jump.code2021.tree;

public class TrimBST {


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

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null){
            return null;
        }

        if(root.val<low){
            return trimBST(root.right,low,high);
        }
        else if(root.val>high){
            return trimBST(root.left,low,high);
        }
        else{
            TreeNode l = trimBST(root.left, low,high);
            TreeNode r = trimBST(root.right, low,high);
            root.left = l;
            root.right =r;
            return root;
        }
    }

    public static void main(String[] args){
        TreeNode r1 = new TreeNode(1);
        TreeNode d11 = new TreeNode(0);
        TreeNode d12 = new TreeNode(2);
//        TreeNode d21 = new TreeNode(5);
//        TreeNode d22 = new TreeNode(3);
//        TreeNode d23 = new TreeNode(9);
//        TreeNode d24 = new TreeNode(7);
//        TreeNode d31 = new TreeNode(4);
//        TreeNode d32 = new TreeNode(8);

        r1.left = d11;
        r1.right = d12;
//        d11.left = d21;
//        d11.right = d22;
//        d12.right = d23;

        TreeNode r2 = new TreeNode(3);
        TreeNode c11 = new TreeNode(0);
        TreeNode c12 = new TreeNode(4);
        TreeNode c21 = new TreeNode(2);
        TreeNode c31 = new TreeNode(1);

        r2.left=c11;
        r2.right=c12;
        c11.right=c21;
        c21.left=c31;

        TrimBST t = new TrimBST();
        TreeNode r =t.trimBST(r2,1,3);
        System.out.println(r);
    }
}
