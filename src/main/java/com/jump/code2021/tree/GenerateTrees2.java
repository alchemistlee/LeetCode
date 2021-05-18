package com.jump.code2021.tree;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees2 {



    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n) {

        List<TreeNode> res = geneIt(1,n);
        return res;
    }

    private List<TreeNode> geneIt(int start, int end){

        List<TreeNode> res = new ArrayList<>();


        if(start>end){
            res.add(null);
            return res;
        }

        for(int i=start;i<=end;i++){

            List<TreeNode> lr= geneIt(start,i-1);
            List<TreeNode> rr = geneIt(i+1,end);

            for(TreeNode ln : lr){
                for(TreeNode rn : rr){
                    TreeNode t = new TreeNode(i);
                    t.left=ln;
                    t.right=rn;
                    res.add(t);
                }
            }
        }
        return res;

    }

    public  static void main(String[] args){
        GenerateTrees2 g2 = new GenerateTrees2();
        List<TreeNode> r = g2.generateTrees(1);
        System.out.println(r.size());
    }
}
