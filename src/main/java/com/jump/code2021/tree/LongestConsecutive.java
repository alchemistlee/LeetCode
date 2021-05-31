package com.jump.code2021.tree;

public class LongestConsecutive {

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

    public int longestConsecutive(TreeNode root) {

        longest(root, root.val-1, 1);
        return this.longesrtLen;
    }

    private int longesrtLen=1;

    private void longest(TreeNode root, int parentVal ,int curLen){
        if(root==null){
            return;
        }

        int tmpLen = curLen+1;
        if(parentVal+1 == root.val){
            if(tmpLen > this.longesrtLen ){
                this.longesrtLen = tmpLen;
            }
        }
        else{
            tmpLen = 1;

        }

        longest(root.left , root.val, tmpLen);
        longest(root.right, root.val, tmpLen);
    }

    public static void main(String[] args){

        TreeNode r1 = new TreeNode(1);
        TreeNode n11 = new TreeNode(3);
//        TreeNode n12 = new TreeNode(6);
        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(4);
        TreeNode n31 = new TreeNode(5);

//        r1.left= n11;
        r1.right = n11;
        n11.left = n21;
        n11.right = n22;
        n22.right = n31;

        LongestConsecutive l = new LongestConsecutive();
        int r= l.longestConsecutive(r1);
        System.out.println(r);
    }
}
