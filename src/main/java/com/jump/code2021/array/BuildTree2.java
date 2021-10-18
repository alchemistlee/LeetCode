package com.jump.code2021.array;

import java.util.ArrayList;
import java.util.List;

public class BuildTree2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> ii = trans2List(inorder);
        List<Integer> pp = trans2List(postorder);

        TreeNode res = buildIt(ii, pp);

        return res;
    }

    private TreeNode buildIt(List<Integer> inOrd, List<Integer> postOrd){
        if(postOrd==null || postOrd.size()<1){
            return null;
        }

        TreeNode root = new TreeNode(postOrd.get(postOrd.size()-1));

        int rootIdx = inOrd.indexOf(root.val);

        List<Integer> leftIn = inOrd.subList(0, rootIdx);
        List<Integer> rightIn =  inOrd.subList(rootIdx+1,inOrd.size());

        List<Integer> leftPost = postOrd.subList(0,leftIn.size());
        List<Integer> rightPost = postOrd.subList(leftIn.size(),postOrd.size()-1);

        root.left = buildIt(leftIn,leftPost);
        root.right = buildIt(rightIn,rightPost);

        return root;
    }

    private List<Integer> trans2List(int[] d){
        List<Integer> r = new ArrayList<>();
        for(int i=0;i<d.length;i++){
            r.add(d[i]);
        }
        return r;
    }

    public static void main(String[] args){
        int[] a= new int[]{9,3,15,20,7};
        int[] b= new int[]{9,15,7,20,3};

        BuildTree2 b2 = new BuildTree2();
        TreeNode r = b2.buildTree(a,b);
    }
}
