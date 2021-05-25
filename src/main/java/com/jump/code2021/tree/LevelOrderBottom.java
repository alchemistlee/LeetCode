package com.jump.code2021.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();

        if(root==null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);



        while (!q.isEmpty()){

            int curLevelSize = q.size();

            List<Integer> tmpLevel = new ArrayList<>();

            for(int i=0;i<curLevelSize;i++) {

                TreeNode cur = q.poll();
                tmpLevel.add(cur.val);

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }

            res.add(0,tmpLevel);

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

        LevelOrderBottom a = new LevelOrderBottom();
        List<List<Integer>> r = a.levelOrderBottom(root);
        System.out.println(r);

    }

}
