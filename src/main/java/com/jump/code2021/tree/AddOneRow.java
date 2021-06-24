package com.jump.code2021.tree;

public class AddOneRow {

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

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode res = addit(root,val,depth,1);
        return res;
    }


    private TreeNode addit(TreeNode root, int v, int d, int curDep){
        if(root==null){
            return null;
        }

        if(d==1){
            TreeNode res = new TreeNode(v);
            res.left = root;
            return res;
        }

        if(curDep==d-1){
            TreeNode oriLeft = root.left;
            TreeNode oriRight = root.right;

            TreeNode newLeft = new TreeNode(v);
            TreeNode newRight = new TreeNode(v);

            root.left = newLeft;
            root.right= newRight;

            newLeft.left = oriLeft;
            newRight.right = oriRight;

            return root;
        }
        else{
            addit(root.left,v,d,curDep+1);
            addit(root.right,v,d,curDep+1);

            return root;
        }

    }

    public static void main(String[] args){
        TreeNode r2 = new TreeNode(4);
        TreeNode d11 = new TreeNode(2);
        TreeNode d12 = new TreeNode(6);
        TreeNode d21 = new TreeNode(3);
        TreeNode d22 = new TreeNode(1);
        TreeNode d23 = new TreeNode(5);
//        TreeNode d24 = new TreeNode(7);
//        TreeNode d31 = new TreeNode(3);
//        TreeNode d32 = new TreeNode(8);

        r2.left = d11;
        r2.right = d12;
        d11.left = d21;
        d11.right = d22;
        d12.left = d23;

        AddOneRow a = new AddOneRow();
        TreeNode res = a.addOneRow(r2,1,2);
        System.out.println(res);
    }
}
