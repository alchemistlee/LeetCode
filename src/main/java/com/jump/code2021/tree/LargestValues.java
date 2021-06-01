package com.jump.code2021.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues {

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

    public List<Integer> largestValues(TreeNode root) {
        if(root==null){
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()){

            int curLevel = q.size();

            int curMax = 0;
            for(int i=0;i<curLevel;i++){
                TreeNode cur = q.poll();
                if(curMax<cur.val){
                    curMax = cur.val;
                }
                if(cur.left!=null){
                    q.offer(cur.left);
                }

                if(cur.right!=null){
                    q.offer(cur.right);
                }
            }

            res.add(curMax);

        }
        return res;
    }

    public static void main(String[] args){
        TreeNode r2 = new TreeNode(1);
        TreeNode d11 = new TreeNode(3);
        TreeNode d12 = new TreeNode(2);
        TreeNode d21 = new TreeNode(5);
        TreeNode d22 = new TreeNode(3);
        TreeNode d23 = new TreeNode(9);
//        TreeNode d31 = new TreeNode(7);

        r2.left = d11;
        r2.right = d12;
        d11.left = d21;
        d11.right = d22;
        d12.right = d23;

        LargestValues l = new LargestValues();
        List<Integer> res = l.largestValues(r2);
        System.out.println(res);

    }
}
