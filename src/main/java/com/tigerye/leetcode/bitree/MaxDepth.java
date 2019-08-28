package com.tigerye.leetcode.bitree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : alchemistlee on 2019/8/15
 * @version : 0.0.1
 **/

public class MaxDepth {

    static  class TreeNode {
      int val;
      TreeNode left=null;
      TreeNode right=null;
      TreeNode(int x) { val = x; }
    }

    static int maxDepth(TreeNode root) {

        if(root.left==null && root.right==null){
            return 1;
        }
        int left_dep = 0;
        if(root.left!=null){
            int tmp_dep = maxDepth(root.left);
            left_dep= tmp_dep+1;
        }
        int right_dep =0;
        if(root.right!=null){
            int tmp_dep = maxDepth(root.right);
            right_dep=tmp_dep+1;
        }

        return Math.max(left_dep,right_dep);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);

        root.left = n1;
        root.right = n2;
        n2.left=n3;
        n2.right=n4;

        System.out.println(maxDepth(root));

    }
}
