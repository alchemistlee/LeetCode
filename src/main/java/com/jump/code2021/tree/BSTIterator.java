package com.jump.code2021.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTIterator {

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

    List<Integer> content;

    public BSTIterator(TreeNode root) {

        this.content = new LinkedList<>();
        buildIt(root);
    }

    private void buildIt(TreeNode root){
        if(root == null){
            return;
        }

        buildIt(root.left);
        this.content.add(root.val);
        buildIt(root.right);

    }


    public int next() {
        Integer res = this.content.get(0);
        this.content.remove(0);
        return res.intValue();
    }

    public boolean hasNext() {
        return !this.content.isEmpty();
    }


    public static void main(String[] args){

        TreeNode r1 = new TreeNode(7);
        TreeNode n11 = new TreeNode(3);
        TreeNode n12 = new TreeNode(15);
        TreeNode n31 = new TreeNode(9);
        TreeNode n32 = new TreeNode(20);
        TreeNode n33 = new TreeNode(4);

        r1.left=n11;
        r1.right =n12;
        n12.left=n31;
        n12.right=n32;


        BSTIterator b = new BSTIterator(r1);
        System.out.println(b.next());  // 返回 3
        System.out.println(b.next());    // 返回 7
        System.out.println(b.hasNext()); // 返回 True
        System.out.println(b.next());    // 返回 9
        System.out.println(b.hasNext()); // 返回 True
        System.out.println(b.next());    // 返回 15
        System.out.println(b.hasNext()); // 返回 True
        System.out.println(b.next());    // 返回 20
        System.out.println(b.hasNext());

    }
}
