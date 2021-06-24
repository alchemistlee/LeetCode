package com.jump.code2021.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

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

    private Map<String, TreeNode> mem = new HashMap<>();
    private List<TreeNode> dups = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        findDuptree(root);
        return dups;
    }

    public String findDuptree(TreeNode root){
        if(root==null){
            return "#";
        }

        String leftRes = findDuptree(root.left);
        String rightRes = findDuptree(root.right);

        String curKey = root.val+","+leftRes+","+rightRes;
        if(mem.containsKey(curKey)){
            TreeNode tar = mem.get(curKey);
            if(!dups.contains(tar)) {
                dups.add(tar);
            }
        }
        else{
            mem.put(curKey,root);
        }
        return curKey;

    }

    public static void main(String[] args){
        TreeNode r2 = new TreeNode(1);
        TreeNode d11 = new TreeNode(2);
        TreeNode d12 = new TreeNode(3);
        TreeNode d21 = new TreeNode(4);
        TreeNode d22 = new TreeNode(2);
        TreeNode d23 = new TreeNode(4);
//        TreeNode d24 = new TreeNode(7);
        TreeNode d31 = new TreeNode(4);
//        TreeNode d32 = new TreeNode(8);

        r2.left = d11;
        r2.right = d12;
        d11.left = d21;
        d12.left = d22;
        d12.right = d23;
        d22.left= d31;

        FindDuplicateSubtrees f = new FindDuplicateSubtrees();
        List<TreeNode> res= f.findDuplicateSubtrees(r2);

        System.out.println(res);

    }
}
