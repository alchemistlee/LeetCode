package com.jump.code2021.tree;

public class InorderSuccessor {

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

    private TreeNode target = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        findSucc(root,p);
        return this.target;
    }

    private void findSucc(TreeNode root, TreeNode p){
        if(root == null){
            return;
        }

        findSucc(root.left,p);
        if(root.val>p.val && this.target == null){
            this.target = root;

        }

        findSucc(root.right,p);
    }

    public static void main(String[] args){

        TreeNode r1 = new TreeNode(5);
        TreeNode n11 = new TreeNode(3);
        TreeNode n12 = new TreeNode(6);
        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(4);
        TreeNode n31 = new TreeNode(1);

        r1.left= n11;
        r1.right = n12;
        n11.left = n21;
        n11.right = n22;
        n21.left = n31;


        TreeNode r2 = new TreeNode(2);
        TreeNode n211 = new TreeNode(1);
        TreeNode n212 = new TreeNode(3);
        r2.left = n211;
        r2.right = n212;

        InorderSuccessor a = new InorderSuccessor();
        TreeNode t = a.inorderSuccessor(r2,n211);

        System.out.println(t);
    }
}
