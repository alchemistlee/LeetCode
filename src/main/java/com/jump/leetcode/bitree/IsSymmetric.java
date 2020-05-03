package com.jump.leetcode.bitree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : alchemistlee on 2019/8/16
 * @version : 0.0.1
 **/

public class IsSymmetric {

    static  class TreeNode {
        int val;
        TreeNode left=null;
        TreeNode right=null;
        TreeNode(int x) { val = x; }
    }


    static boolean isSymmetric(TreeNode root) {
        List<TreeNode> stages = new ArrayList<>();
        if(root.left==null && root.right==null){
            return true;
        }
        else if(root.left==null || root.right==null){
            return false;
        }

        stages.add(root.left);
        stages.add(root.right);

        while (stages.size()>0){

            if(stages.size()%2!=0){
                return false;
            }

            for(int i=0;i<stages.size()/2;i++){
                TreeNode t1 = stages.get(i);
                TreeNode t2 = stages.get(stages.size()-1-i);
                if(t1==null && t2==null){
                    continue;
                }
                else if(t1==null || t2==null){
                    return false;
                }
                else if(t1.val!=t2.val){
                    return false;
                }
            }

            List<TreeNode> tmp = new ArrayList<>();
            boolean isChildAllEpt = true;
            for(TreeNode item : stages){
                if(item==null){
                    tmp.add(item);
                    continue;
                }
                if(item.left!=null || item.right!=null){
                    isChildAllEpt=false;
                }
                tmp.add(item.left);
                tmp.add(item.right);
            }
            stages.clear();
            if(!isChildAllEpt) {
                stages.addAll(tmp);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);

        root.left = n1;
        root.right = n2;
//        n1.left = n3;
        n1.right=n4;
//        n2.left = n6;
        n2.right=n5;

        System.out.println(isSymmetric(root));

    }
}
