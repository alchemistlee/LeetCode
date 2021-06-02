package com.jump.code2021.tree;

public class ConvertBST {

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

    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null;
        }

        covIt(root,0);
        return root;
    }


    private int covIt(TreeNode root, int rightSum){
        if(root==null){
            return 0;
        }

        int rSum = covIt(root.right,rightSum);

        int originVal = root.val;
        root.val = root.val +rSum + rightSum;
//        if(root.left!=null){
//            root.left.val = root.left.val+root.val;
//        }
        int lSum = covIt(root.left,root.val);
        return lSum+originVal+rSum;
    }

    public static void main(String[] args){
        TreeNode r2 = new TreeNode(4);
        TreeNode d11 = new TreeNode(1);
        TreeNode d12 = new TreeNode(6);
        TreeNode d21 = new TreeNode(0);
        TreeNode d22 = new TreeNode(2);
        TreeNode d23 = new TreeNode(5);
        TreeNode d24 = new TreeNode(7);
        TreeNode d31 = new TreeNode(3);
        TreeNode d32 = new TreeNode(8);

        r2.left = d11;
        r2.right = d12;
        d11.left = d21;
        d11.right = d22;
        d12.left = d23;
        d12.right = d24;
        d22.right =d31;
        d24.right =d32;

        ConvertBST cb = new ConvertBST();

        TreeNode res = cb.convertBST(r2);

        System.out.println(res);

    }
}
