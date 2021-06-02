package com.jump.code2021.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Str2tree {


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

    public TreeNode str2tree(String s) {
        TreeNode res = buildIt(s,0,s.length()-1);
        return res;
    }


    private TreeNode buildIt(String s, int start, int end){
        if(start>end){
            return null;
        }

        String curStr = s.substring(start,end+1);

        String rStr = curStr.substring(0,1);
        int nextIdx = start+1;

        TreeNode curNode = new TreeNode();
        curNode.val = Integer.valueOf(rStr);

        if(nextIdx>end){
            return curNode;
        }

        List<String> stack = new ArrayList<>();

        StringBuilder sb  = new StringBuilder();

        int idx = nextIdx;
        do {
            String tmp = s.substring(idx,idx+1);
            if(tmp.equals("(")) {
                stack.add(tmp);
            }
            else if(tmp.equals(")")){
                stack.remove(stack.size()-1);
            }
            sb.append(tmp);
            idx+=1;
        }
        while (!stack.isEmpty());

        int childEndIdx = start+sb.length()-1;
        TreeNode l = buildIt(s,start+2, childEndIdx);
        curNode.left = l;

        if(start+sb.length()+1>= end){
            return curNode;
        }

        TreeNode r = buildIt(s, start+sb.length()+2,end-1);
        curNode.right = r;


        return curNode;
    }

    public static void main(String[] args){
        String s = "4(2(3)(1))(6(5))";
//        System.out.println(s.substring(0,0));
        Str2tree st = new Str2tree();
        TreeNode r = st.str2tree(s);
        System.out.println(r);
    }
}
