package com.jump.code2021.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeBST {


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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        seriIt(root,sb);
        String res = "";
        if(sb.length()>0){
            res = sb.substring(0,sb.length()-1);
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] t1 =data.split(",");

        Queue<String> q = new LinkedList<>();

        for(int i=0;i<t1.length;i++){
            q.offer(t1[i]);
        }

        TreeNode root=new TreeNode(Integer.valueOf(q.poll()));
        deseriIt(root,Integer.MIN_VALUE,Integer.MAX_VALUE,q);

        return root;
    }

    private void deseriIt(TreeNode root, int min, int max, Queue<String> queue){
        if(queue.isEmpty()){
            return;
        }

        int curVal = Integer.valueOf(queue.peek());
        if(curVal>=max || curVal<= min){
            return;
        }

        if(curVal<root.val && curVal >min){
            TreeNode ln = new TreeNode(curVal);
            root.left = ln;
            queue.poll();
            deseriIt(root.left,min,root.val,queue);
        }

        curVal = Integer.valueOf(queue.peek());
        if(curVal>root.val && curVal<max){
            TreeNode rn = new TreeNode(curVal);
            root.right=rn;
            queue.poll();
            deseriIt(root.right,root.val,max,queue);
        }
    }


    private void seriIt(TreeNode root, StringBuilder sb){
        if(root==null){
            return;
        }

        sb.append(root.val);
        sb.append(",");

        seriIt(root.left,sb);
        seriIt(root.right, sb);
    }

    public static void main(String[] args){
        TreeNode r1 = new TreeNode(2);
        TreeNode n11 = new TreeNode(1);
        TreeNode n12 = new TreeNode(3);
//        TreeNode n21 = new TreeNode(4);
//        TreeNode n22 = new TreeNode(5);
        r1.left = n11;
        r1.right = n12;

        SerializeBST s = new SerializeBST();

        String rs1 =s.serialize(r1);
        System.out.println(rs1);

        TreeNode tr = s.deserialize(rs1);
        System.out.println(tr);
    }
}
