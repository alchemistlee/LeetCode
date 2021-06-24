package com.jump.code2021.tree;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinTree {


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

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int res = 0;

        while (!q.isEmpty()){

            int curLevSize = q.size();
            int lastNotNullIdx=0;
            boolean isAllNull = true;
            for(int i=0;i<curLevSize;i++){
                TreeNode curNode = q.poll();

                if(curNode!=null) {

                    q.offer(curNode.left);
                    q.offer(curNode.right);
                    lastNotNullIdx = i;

                    if(curNode.left!=null || curNode.right!=null){
                        isAllNull=false;
                    }
                }
                else{
                    q.offer(null);
                    q.offer(null);
                }
            }

            if(res<lastNotNullIdx+1){
                res = lastNotNullIdx+1;
            }

            if(isAllNull){
                break;
            }

        }

        return res;

    }




    public static void main(String[] args){
        TreeNode r1 = new TreeNode(1);
        TreeNode d11 = new TreeNode(3);
        TreeNode d12 = new TreeNode(2);
        TreeNode d21 = new TreeNode(5);
        TreeNode d22 = new TreeNode(3);
        TreeNode d23 = new TreeNode(9);
//        TreeNode d24 = new TreeNode(7);
//        TreeNode d31 = new TreeNode(4);
//        TreeNode d32 = new TreeNode(8);

        r1.left = d11;
        r1.right = d12;
        d11.left = d21;
        d11.right = d22;
        d12.right = d23;


        TreeNode r2 = new TreeNode(1);
        TreeNode c11 = new TreeNode(3);
        TreeNode c21 = new TreeNode(5);
        TreeNode c22 = new TreeNode(3);

        r2.left=c11;
        c11.left= c21;
        c11.right=c22;

        WidthOfBinTree w = new WidthOfBinTree();
        System.out.println(w.widthOfBinaryTree(r2));

    }
}
