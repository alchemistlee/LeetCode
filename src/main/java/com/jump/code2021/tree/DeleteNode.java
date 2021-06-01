package com.jump.code2021.tree;

public class DeleteNode {

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


    public TreeNode deleteNode(TreeNode root, int key){
        if(root==null){
            return null;
        }

        TreeNode child = null;
        if(root.val == key){
            if(root.left == null && root.right==null){
                return null;
            }
            else if(root.left == null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                TreeNode tmp = root.left.right;
                if(tmp==null){
                    root.left.right = root.right;
                    return root.left;
                }
                else{
                    TreeNode  cur = root.right;
                    while (cur.left!=null){
                        cur = cur.left;
                    }
                    cur.left=tmp;
                    root.left.right =  root.right;
                    return root.left;
                }
            }
        }
        else if(root.val < key){
            child = deleteNode(root.right,key);
            root.right = child;
        }
        else{
            child  = deleteNode(root.left, key);
            root.left = child;
        }
        return root;

    }

    public static void  main(String[] args){
        TreeNode r1 = new TreeNode(5);
        TreeNode n11 = new TreeNode(3);
        TreeNode n12 = new TreeNode(6);
        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(4);
        TreeNode n23 = new TreeNode(7);

        r1.left = n11;
        r1.right = n12;
        n11.left = n21;
        n11.right = n22;
        n12.right = n23;

        DeleteNode d = new DeleteNode();
        TreeNode r =d.deleteNode(r1,3);

        System.out.println(r);


    }
}
