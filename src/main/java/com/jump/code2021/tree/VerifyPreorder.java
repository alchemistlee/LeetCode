package com.jump.code2021.tree;

public class VerifyPreorder {

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

    private int curIdx=0;

    public boolean verifyPreorder(int[] preorder) {
        if(preorder.length==0){
            return false;
        }

        TreeNode root =  new TreeNode();
        root.val = preorder[curIdx];
        curIdx+=1;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        verifyIt(root, min, max, preorder);

        if(preorder.length>curIdx){
            return false;
        }
        return true;
    }


    private void verifyIt(TreeNode root, int min, int max,int[] preorrder){

        while(curIdx<preorrder.length && (root.left==null||root.right==null)) {


            int curVal = preorrder[curIdx];

            if (curVal <= min || curVal >= max) {
                break;
            }

            curIdx+=1;

            TreeNode n = new TreeNode(curVal);


            if (curVal < root.val) {

                root.left = n;
                verifyIt(root.left, min, root.val, preorrder);

            }
            else{
                root.right = n;
                verifyIt(root.right, root.val,max,preorrder);
            }
        }

    }

    public static void main(String[] args){


        VerifyPreorder v = new VerifyPreorder();
        int[] a =new int[]{5,2,1,3,6};

        boolean r = v.verifyPreorder(a);

        System.out.println(r);


    }
}
