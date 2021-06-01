package com.jump.code2021.tree;

public class InorderSuccessor2 {

    private static class Node {

        int val;
        Node left=null;
        Node right=null;
        Node parent = null;
        Node() {}
        Node(int val) { this.val = val; }
    }

    public Node inorderSuccessor(Node node) {
        Node res ;
        if(node.right!=null){
            res= findLeftChild(node.right);
        }
        else{
            res = findLeftParent(node);
        }
        return res;
    }


    private Node findLeftChild(Node node){
        if(node==null){
            return null;
        }
        Node res = findLeftChild(node.left);
        if(res == null){
            return node;
        }
        return res;
    }

    private Node findLeftParent(Node node){
        if(node.parent==null){
            return null;
        }

        if(node.parent.left == node){
            return node.parent;
        }

        Node res=findLeftParent(node.parent);
        return res;

    }

    public static void main(String[] args){

        Node r1 = new Node(2);
        Node n11 = new Node(1);
        Node n12 = new Node(3);
//        TreeNode n21 = new TreeNode(2);
//        TreeNode n22 = new TreeNode(4);
//        TreeNode n23 = new TreeNode(7);

        r1.left = n11;
        r1.right = n12;
        n11.parent = r1;
        n12.parent = r1;

        InorderSuccessor2 i2 = new InorderSuccessor2();
        Node r= i2.inorderSuccessor(n12);
        System.out.println(r);
    }
}
