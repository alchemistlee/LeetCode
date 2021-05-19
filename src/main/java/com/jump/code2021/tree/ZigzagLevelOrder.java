package com.jump.code2021.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int levelIdx = 0;
        while (!q.isEmpty()){
            int curLevelSize = q.size();
            List<Integer> tmpLevel = new ArrayList<>();
            for(int i=0;i<curLevelSize;i++) {
                TreeNode curNode = q.poll();
                tmpLevel.add(curNode.val);


                if(levelIdx % 2 ==0) {
                    if (curNode.left != null) {
                        q.offer(curNode.left);
                    }

                    if (curNode.right != null) {
                        q.offer(curNode.right);
                    }
                }
                if(levelIdx % 2 ==1){
                    if (curNode.right != null) {
                        q.offer(curNode.right);
                    }

                    if (curNode.left != null) {
                        q.offer(curNode.left);
                    }
                }
            }
            res.add(tmpLevel);
            levelIdx+=1;
        }

        return res;
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);

        root.left=n1;
        root.right=n2;
        n2.left =n3;
        n2.right=n4;

        ZigzagLevelOrder z = new ZigzagLevelOrder();
        List<List<Integer>> r = z.zigzagLevelOrder(root);
        System.out.println(r);

    }

}
