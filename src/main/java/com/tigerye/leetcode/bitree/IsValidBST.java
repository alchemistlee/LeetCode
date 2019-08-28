package com.tigerye.leetcode.bitree;

import com.sun.org.apache.xml.internal.resolver.readers.TR9401CatalogReader;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author : alchemistlee on 2019/8/15
 * @version : 0.0.1
 **/

public class IsValidBST {

    static  class TreeNode {
        int val;
        TreeNode left=null;
        TreeNode right=null;
        TreeNode(int x) { val = x; }
    }

    static class TreeInfo{
        int max;
        int min;
        boolean isValid;
        TreeInfo(boolean i ,int max, int min){
            this.max = max;
            this.min = min;
            isValid =i;
        }

    }


    static TreeInfo getMaxMin(TreeNode r){
        if(r.left==null && r.right==null){
            return new TreeInfo(true,r.val,r.val);
        }

        TreeInfo cl=null;
        TreeInfo cr=null;
        if(r.left!=null){
            cl = getMaxMin(r.left);
        }

        if(r.right!=null){
            cr=getMaxMin(r.right);
        }
        TreeInfo res = new TreeInfo(true,r.val,r.val);
        if(cl!=null){
            if(cl.max<=r.val && cl.isValid){
//                res.isValid = true;
                res.min = cl.min;
            }
            else{
                res.isValid =false;
                return res;
            }
        }

        if(cr!=null){
            if(cr.min>=r.val && cr.isValid){
//                res.isValid = true;
                res.max = cr.max;
            }
            else{
                res.isValid = false;
                return res;
            }
        }

        return res;
    }

    static boolean isValidBST(TreeNode root) {
        TreeInfo rInfo = getMaxMin(root);
        return  rInfo.isValid;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(6);

        root.left = n1;
        root.right = n2;
//        n2.left=n3;
//        n2.right=n4;

        System.out.println(isValidBST(root));
    }
}
