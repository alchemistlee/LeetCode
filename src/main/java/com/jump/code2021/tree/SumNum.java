package com.jump.code2021.tree;



import java.util.ArrayList;
import java.util.List;

public class SumNum {

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

    public int sumNumbers(TreeNode root) {
        List<String> r =  sumIt(root);
        int s = 0;
        for(String item : r){
            s+=Integer.valueOf(item);
        }
        return s;
    }

    private List<String> sumIt(TreeNode root){
        List<String> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        String cur = root.val+"";

        List<String> left = sumIt(root.left);
        List<String> right = sumIt(root.right);

        if(left.size()==0 && right.size()==0){
            res.add(cur);
            return res;
        }

        if(left.size()>0){
            for(String item : left){
                String tmp = cur + item;
                res.add(tmp);
            }
        }

        if(right.size()>0){
            for(String item : right){
                String tmp = cur + item;
                res.add(tmp);
            }
        }

        return res;

    }


    public static void main(String[] args){

        TreeNode r1 = new TreeNode(4);
        TreeNode n11 = new TreeNode(9);
        TreeNode n12 = new TreeNode(0);
        TreeNode n31 = new TreeNode(5);
        TreeNode n32 = new TreeNode(1);
        TreeNode n33 = new TreeNode(4);

        r1.left=n11;
        r1.right =n12;
        n11.left=n31;
        n11.right=n32;

        SumNum s = new SumNum();
        int sn = s.sumNumbers(r1);
        System.out.println(sn);
    }
}
