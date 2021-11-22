package com.jump.code2021.square;

import java.util.ArrayList;
import java.util.List;

public class BinTreeDepth {

    class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

    }

    public int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftDep = 0;
        int rightDep = 0;
        if(root.left!=null){
            leftDep = getDepth(root.left);
        }
        if(root.right!=null){
            rightDep = getDepth(root.right);
        }

        return 1+Math.max(leftDep,rightDep);
    }

    public int getDepth2(TreeNode root){
        int res = 0;
        List<TreeNode> curLevel = new ArrayList<>();
        curLevel.add(root);

//        int curSize = curLevel.size();
        while (curLevel.size()>0) {
            List<TreeNode> tmp = new ArrayList<>();
            res++;
            for (int i = 0; i < curLevel.size(); i++) {

                TreeNode curNode = curLevel.get(i);
                if (curNode.left != null) {
                    tmp.add(curNode.left);
                }

                if (curNode.right != null) {
                    tmp.add(curNode.right);
                }

            }
            curLevel.clear();
            curLevel.addAll(tmp);
        }
        return res;
    }


    public static void main(String[] args){

    }
}
