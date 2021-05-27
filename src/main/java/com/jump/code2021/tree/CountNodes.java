package com.jump.code2021.tree;

public class CountNodes {

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

    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }

        int l = countNodes(root.left);
        int r = countNodes(root.right);
        int res = l+r+1;

        return res;
    }


    private int get_h(TreeNode root){
        if(root==null){
            return 0;
        }

        return 1+get_h(root.left);
    }

    public int countNodes2(TreeNode root) {
        int hIdx = get_h(root) - 1;


        //目标数的范围是[2^hidx , 2^(hidx+1)-1]

        int start = Double.valueOf(Math.pow(2, hIdx)).intValue();
        int end = Double.valueOf(Math.pow(2, hIdx + 1) - 1).intValue();


        while()

        int target = (end - start) / 2;


    }


    public static void main(String[] args){
        TreeNode r1 = new TreeNode(1);
        TreeNode n11 = new TreeNode(2);
        TreeNode n12 = new TreeNode(3);
        TreeNode n31 = new TreeNode(4);
        TreeNode n32 = new TreeNode(5);
        TreeNode n33 = new TreeNode(6);

        r1.left=n11;
        r1.right =n12;
        n11.left=n31;
        n11.right=n32;
        n12.left = n33;


        CountNodes c = new CountNodes();
        int res = c.countNodes(r1);
        System.out.println(res);
    }
}
