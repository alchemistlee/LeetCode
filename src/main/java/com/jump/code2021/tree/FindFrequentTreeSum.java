package com.jump.code2021.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFrequentTreeSum {

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

    public int[] findFrequentTreeSum(TreeNode root) {
        treeSum(root);
        List<Integer> res = new ArrayList<>();
        int maxCnt = 0;
        for(Integer k : this.m.keySet()){
            Integer v = this.m.get(k);
            if(v>maxCnt){
                maxCnt = v;
                res.clear();
                res.add(k);
            }
            else if(v==maxCnt){
                res.add(k);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    private Map<Integer,Integer> m= new HashMap<>();

    private int treeSum(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = treeSum(root.left);
        int r = treeSum(root.right);

        int s = root.val + l + r;
            if(m.containsKey(s)){
            Integer t = m.get(s);
            t+=1;
            m.put(s,t);
        }
        else{
            m.put(s,1);
        }

        return s;
    }

    public static void main(String[] args){

        TreeNode r1 = new TreeNode(5);
        TreeNode n11 = new TreeNode(2);
        TreeNode n12 = new TreeNode(-5);
//        TreeNode n21 = new TreeNode(2);
//        TreeNode n22 = new TreeNode(4);
//        TreeNode n23 = new TreeNode(7);

        r1.left = n11;
        r1.right = n12;
//        n11.left = n21;
//        n11.right = n22;
//        n12.right = n23;
        FindFrequentTreeSum f = new FindFrequentTreeSum();
        int[] res = f.findFrequentTreeSum(r1);

        System.out.println(res);
    }
}
