package com.jump.code2021.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {

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

    public int kthSmallest(TreeNode root, int k) {

        List<Integer> res = new ArrayList<>();
        findIt(root, k, res);

        return res.get(res.size()-1);
    }


    private void findIt(TreeNode root, int k, List<Integer> d){
        if(root==null ){
            return ;
        }

        findIt(root.left, k, d);
        if(d.size()!=k) {
            d.add(root.val);
            return;
        }
        findIt(root.right, k,d);
    }

    public static void main(String[] args){

        TreeNode r1 = new TreeNode(3);
        TreeNode n11 = new TreeNode(1);
        TreeNode n12 = new TreeNode(4);
        TreeNode n31 = new TreeNode(2);
        TreeNode n32 = new TreeNode(5);
        TreeNode n33 = new TreeNode(6);

        r1.left=n11;
        r1.right =n12;
//        n11.left=n31;
        n11.right=n31;
//        n12.left = n33;


        TreeNode r2 = new TreeNode(5);
        TreeNode r11 = new TreeNode(3);
        TreeNode r12 = new TreeNode(6);
        TreeNode r21 = new TreeNode(2);
        TreeNode r22 = new TreeNode(4);
        TreeNode r31 = new TreeNode(1);

        r2.left = r11;
        r2.right = r12;
        r11.left =r21;
        r11.right=r22;
        r21.left=r31;


        KthSmallest k = new KthSmallest();
        int r =k.kthSmallest(r2,3);
        System.out.println(r);


    }
}
