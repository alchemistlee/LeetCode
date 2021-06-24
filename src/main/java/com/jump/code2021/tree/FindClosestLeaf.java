package com.jump.code2021.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FindClosestLeaf {

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

    private static class LeafResult{
        int dis=0;
        int val=0;

        LeafResult(){}
    }


    public int findClosestLeaf(TreeNode root, int k) {
        closeLeaf(root);

        Queue<TreeNode> p = new LinkedList<>();

        getTarPath(root,k,p);

        int tarDis = 0;
        while(!p.isEmpty()){
            TreeNode n = p.poll();
            LeafResult leafRes = m.get(n.val);

            int curNearestDis = leafRes.dis+tarDis;

            if(curNearestDis<minPath){
                minPath = curNearestDis;
                minVal = leafRes.val;
            }
            tarDis+=1;
        }

        return minVal;
    }

    private int minPath=Integer.MAX_VALUE;
    private int minVal=0;

    private Map<Integer,LeafResult> m = new HashMap<>();

    private LeafResult closeLeaf (TreeNode root){
        if(root==null){
            return null;
        }

        LeafResult lRes = closeLeaf(root.left);
        LeafResult rRes = closeLeaf(root.right);

        if(lRes==null && rRes==null){
            LeafResult res = new LeafResult();
            res.val = root.val;
            res.dis= 0;

            m.put(root.val, res);

            return res;
        }

        int curDis = Integer.MAX_VALUE;
        int curVal = 0;

        if(lRes!=null){
            if(lRes.dis+1 < curDis){
                curDis = lRes.dis+1;
                curVal = lRes.val;
            }
        }

        if(rRes!=null){
            if(rRes.dis+1< curDis){
                curDis = rRes.dis+1;
                curVal = rRes.val;
            }
        }

        LeafResult res = new LeafResult();
        res.dis = curDis;
        res.val = curVal;

        m.put(root.val,res);

        return res;
    }


    private boolean getTarPath(TreeNode root, int k, Queue<TreeNode> path){
        if(root==null){
            return false;
        }

        if(root.val==k){
            path.offer(root);
            return true;
        }

        boolean l = getTarPath(root.left,k,path);
        boolean r = getTarPath(root.right,k,path);

        if(l || r){
            path.offer(root);
            return true;
        }
        else{
            return false;
        }

    }



    public static void main(String[] args){
        TreeNode r1 = new TreeNode(1);
        TreeNode d11 = new TreeNode(3);
        TreeNode d12 = new TreeNode(2);
//        TreeNode d21 = new TreeNode(4);
//        TreeNode d22 = new TreeNode(4);
//        TreeNode d23 = new TreeNode(5);

        r1.left=d11;
        r1.right =d12;

        TreeNode r2 = new TreeNode(1);
        TreeNode c11 = new TreeNode(2);
        TreeNode c12 = new TreeNode(3);
        TreeNode c21 = new TreeNode(4);
        TreeNode c31 = new TreeNode(5);
        TreeNode c41 = new TreeNode(6);

        r2.left=c11;
        r2.right=c12;
        c11.left=c21;
        c21.left=c31;
        c31.left=c41;

        FindClosestLeaf f = new FindClosestLeaf();
        System.out.println(f.findClosestLeaf(r2,2));

    }
}
