package com.jump.code2021.tree;

public class Rob {

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

    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }

        int p1 = root.left ==null ? 0 : rob(root.left.left)+rob(root.left.right);
        int p2 = root.right ==null ? 0 : rob(root.right.left)+rob(root.right.right);
        int res = Math.max(root.val+p1+p2, rob(root.left)+rob(root.right) );
        return res;
    }

    public static void main(String[] args){
        TreeNode r1 = new TreeNode(3);
        TreeNode n11 = new TreeNode(2);
        TreeNode n12 = new TreeNode(3);
        TreeNode n21 = new TreeNode(3);
        TreeNode n22 = new TreeNode(1);
//        TreeNode n23 = new TreeNode(7);

        r1.left= n11;
        r1.right = n12;
//        n11.left = n21;
        n11.right = n21;
        n12.right = n22;

        Rob r = new Rob();
        int res = r.rob(r1);
        System.out.println(res);
    }
}
