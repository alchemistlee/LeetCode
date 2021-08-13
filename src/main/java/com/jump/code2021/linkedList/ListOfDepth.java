package com.jump.code2021.linkedList;

import java.util.*;

public class ListOfDepth {



    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        int levelSize = 1;
        q.offer(tree);

        int nextLevel=0;
        ListNode curList =null;

        while (!q.isEmpty()){

            TreeNode curTreeNode = q.poll();

            ListNode tmp = new ListNode(curTreeNode.val);

            if(curList==null){
                curList = tmp;
                res.add(curList);
            }
            else {
                if (levelSize > 0) {
                    curList.next = tmp;
                    curList = tmp;

                } else {
                    levelSize= nextLevel;
                    nextLevel = 0;
                    curList = tmp;
                    res.add(curList);
                }
            }

            if(curTreeNode.left!=null){
                q.offer(curTreeNode.left);
                nextLevel+=1;
            }
            if(curTreeNode.right!=null){
                q.offer(curTreeNode.right);
                nextLevel+=1;
            }

            levelSize--;
        }

        return res.toArray(new ListNode[0]);
    }

    public static void main(String[] args){

        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t7=new TreeNode(7);
        TreeNode t8=new TreeNode(8);

        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.right=t7;
        t4.left=t8;

        ListOfDepth l = new ListOfDepth();

        ListNode[] res = l.listOfDepth(t1);

    }
}
