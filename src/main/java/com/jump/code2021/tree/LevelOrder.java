package com.jump.code2021.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            res.add(null);
            return  res;
        }

        List<Integer> par = new ArrayList<>();
        par.add(root.val);

        res.add(par);

        List<List<Integer>> leftRes = levelOrder(root.left);
        List<List<Integer>> rightRes = levelOrder(root.right);

//        List<Integer> child = new ArrayList<>();
        for(int i=0;i<Math.max(leftRes.size(),rightRes.size());i++){
            List<Integer> tmpLeft = i<leftRes.size()? leftRes.get(i):null;
            List<Integer> tmpRight = i<rightRes.size()? rightRes.get(i):null;

            if(tmpLeft!=null && tmpRight!=null){
                tmpLeft.addAll(tmpRight);
                res.add(tmpLeft);
            }
            else if(tmpLeft!=null){
                res.add(tmpLeft);

            }
            else if(tmpRight!=null){
                res.add(tmpRight);
            }
            else{
                break;
            }
        }

        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            int curLevelSize = q.size();
            List<Integer> tmpLevel = new ArrayList<>();

            for(int i=0;i<curLevelSize;i++) {

                TreeNode cur = q.poll();

//            System.out.println(cur.val);
                tmpLevel.add(cur.val);

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }

            }
            res.add(tmpLevel);
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
//        n2.right=n4;

        LevelOrder l = new LevelOrder();
        List<List<Integer>> r= l.levelOrder2(root);
        System.out.println(r);
    }
}
