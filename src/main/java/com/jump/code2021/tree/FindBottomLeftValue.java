package com.jump.code2021.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue {

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

    public int findBottomLeftValue(TreeNode root) {
        if(root==null){
            return Integer.MIN_VALUE;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        TreeNode levelLeft = null;
        while(!q.isEmpty()){


            int curLevel = q.size();
            levelLeft = null;
            for(int i=0;i<curLevel;i++){

                TreeNode curNode = q.poll();
                if(levelLeft==null){
                    levelLeft = curNode;
                }

                if(curNode.left!=null){
                    q.offer(curNode.left);
                }
                if(curNode.right!=null){
                    q.offer(curNode.right);
                }

            }


        }

        return  levelLeft.val;


    }

    public static void main(String[] args){
        TreeNode r1 = new TreeNode(2);
        TreeNode n11 = new TreeNode(1);
        TreeNode n12 = new TreeNode(3);
//        TreeNode n21 = new TreeNode(2);
//        TreeNode n22 = new TreeNode(4);
//        TreeNode n23 = new TreeNode(7);

        r1.left = n11;
        r1.right = n12;

        TreeNode r2 = new TreeNode(1);
        TreeNode d11 = new TreeNode(2);
        TreeNode d12 = new TreeNode(3);
        TreeNode d21 = new TreeNode(4);
        TreeNode d22 = new TreeNode(5);
        TreeNode d23 = new TreeNode(6);
        TreeNode d31 = new TreeNode(7);

        r2.left = d11;
        r2.right = d12;
        d11.left = d21;
        d12.left = d22;
        d12.right = d23;
        d22.left = d31;

        FindBottomLeftValue fb = new FindBottomLeftValue();
        int res = fb.findBottomLeftValue(r2);

        System.out.println(res);

    }
}
