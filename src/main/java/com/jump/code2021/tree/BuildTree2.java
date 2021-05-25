package com.jump.code2021.tree;

public class BuildTree2 {

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0 || postorder.length==0){
            return null;
        }

        return buildIt(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }

    private TreeNode buildIt(int[] inorder, int[] postorder, int inSt, int inEnd, int postSt, int postEnd){
        if(inSt>inEnd || postSt> postEnd){
            return null;
        }

        int rootVal =  postorder[postEnd];
        int rootIdx = -1;
        for(int i=inSt;i<=inEnd;i++){
            if(rootVal==inorder[i]){
                rootIdx=i;
                break;
            }
        }

        TreeNode root = new TreeNode();
        root.val = rootVal;


        int leftSize = rootIdx-inSt;
        int rightSize = inEnd - rootIdx;

        root.left = buildIt(inorder,postorder,inSt,rootIdx-1,postSt,postSt+leftSize-1);
        root.right = buildIt(inorder,postorder, rootIdx+1,inEnd,postSt+leftSize,postEnd-1);

        return root;

    }

    public static void main(String[] args){
        int[] in = new int[]{9,3,15,20,7};
        int[] post = new int[]{9,15,7,20,3};

        BuildTree2 b = new BuildTree2();
        TreeNode t = b.buildTree(in,post);
        System.out.println(t);
    }

}
