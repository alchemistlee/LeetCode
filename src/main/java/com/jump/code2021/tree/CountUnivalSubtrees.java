package com.jump.code2021.tree;

public class CountUnivalSubtrees {

    private int uniSubtreeCnt =  0;

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

    public int countUnivalSubtrees(TreeNode root) {
        findIt(root);
        return this.uniSubtreeCnt;

    }


    private boolean findIt(TreeNode root){
        if(root==null){
            return true;
        }

        boolean lRes =  findIt(root.left);
        boolean rRes = findIt(root.right);

        if(lRes && rRes){
            if((root.left==null || root.left.val == root.val) && (root.right==null || root.right.val == root.val)){
                this.uniSubtreeCnt+=1;
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){

        TreeNode r1 = new TreeNode(5);
        TreeNode n11 = new TreeNode(1);
        TreeNode n12 = new TreeNode(5);
        TreeNode n21 = new TreeNode(5);
        TreeNode n22 = new TreeNode(5);
        TreeNode n23 = new TreeNode(5);
//        TreeNode n24 = new TreeNode(8);
//        TreeNode n31 = new TreeNode(7);
//        TreeNode n32 = new TreeNode(4);

        r1.left = n11;
        r1.right = n12;
        n11.left = n21;
        n11.right = n22;
        n12.right = n23;


        CountUnivalSubtrees c =new CountUnivalSubtrees();
        int r = c.countUnivalSubtrees(r1);
        System.out.println(r);

    }
}
