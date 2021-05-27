package com.jump.code2021.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

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

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);


        while (!q.isEmpty()){

            int curLevel = q.size();

            int lastVal=-1;
            for(int i=0;i<curLevel;i++){
                TreeNode curNode = q.poll();
                lastVal = curNode.val;


                if(curNode.left!=null){
                    q.offer(curNode.left);
                }

                if(curNode.right!=null){
                    q.offer(curNode.right);
                }
            }
            if(lastVal!=-1) {
                res.add(lastVal);
            }
        }

        return res;
    }

    public static void main(String[] args){
        TreeNode r1 = new TreeNode(1);
        TreeNode n11 = new TreeNode(2);
        TreeNode n12 = new TreeNode(3);
        TreeNode n31 = new TreeNode(5);
        TreeNode n32 = new TreeNode(4);
        TreeNode n33 = new TreeNode(4);

        r1.left=n11;
        r1.right =n12;
        n11.right=n31;
        n12.right=n32;

        RightSideView rs = new RightSideView();
        List<Integer> res =  rs.rightSideView(r1);
        System.out.println(res);
    }
}
