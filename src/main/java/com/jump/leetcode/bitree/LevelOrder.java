package com.jump.leetcode.bitree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : alchemistlee on 2019/8/16
 * @version : 0.0.1
 **/

public class LevelOrder {

    static  class TreeNode {
        int val;
        TreeNode left=null;
        TreeNode right=null;
        TreeNode(int x) { val = x; }
    }

    static List<List<Integer>> levelOrder(TreeNode root) {

        List<Integer> tmp = new ArrayList<>();
        tmp.add(root.val);
        List<List<Integer>> res = new ArrayList<>();
        res.add(tmp);

        if(root.left==null && root.right==null){
            return res;
        }

        List<List<Integer>> tl = new ArrayList<>();
        List<List<Integer>> tr = new ArrayList<>();
        if(root.left!=null){
            tl = levelOrder(root.left);
        }
        if(root.right!=null){
            tr = levelOrder(root.right);
        }

        for(int i=0;i<Math.max(tl.size(), tr.size());i++){
            List<Integer> t1 = new ArrayList<>();
            if(i<tl.size()){
                t1.addAll(tl.get(i));
            }
            if(i<tr.size()){
                t1.addAll(tr.get(i));
            }
            res.add(t1);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
//        TreeNode n5 = new TreeNode(3);
//        TreeNode n6 = new TreeNode(4);

        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right=n4;
//        n2.left = n6;
//        n2.right=n5;

        List<List<Integer>> r = levelOrder(root);

        for(List<Integer> item : r){
            System.out.println(item);
        }
    }
}
