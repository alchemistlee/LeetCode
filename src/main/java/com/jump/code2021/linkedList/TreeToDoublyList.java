package com.jump.code2021.linkedList;

public class TreeToDoublyList {

    private static class Node {
        public int val;
        public Node left;//prev
        public Node right;//next

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        Node res = tree2DouList(root);
        Node h = new Node();
        h.right = res;
        return h;
    }

    private Node tree2DouList(Node root) {
        if(root==null){
            return null;
        }

        Node leftHead= tree2DouList(root.left);
        Node rightHead = tree2DouList(root.right);

        Node real = null;

        if(leftHead == null && rightHead==null){

            root.left = root;
            root.right = root;
            real = root;
        }
        else if(leftHead== null){
            root.left = rightHead.left;
            root.right = rightHead;
            real = root;
        }
        else if(rightHead==null){
            leftHead.left.right =  root;
            root.left = leftHead.left;
            root.right = leftHead;
            real = leftHead;
        }
        else{
            leftHead.left.right = root;
            root.left = leftHead.left;
            root.right = rightHead;
            rightHead.left.right=leftHead;
            leftHead.left = rightHead.left;
            rightHead.left = root;

            real = leftHead;
        }

        return real;

    }

    public static void main(String[] args){
        Node n4 = new Node(4);
        Node n2 = new Node(2);
        Node n5 = new Node(5);
        Node n1 = new Node(1);
        Node n3 = new Node(3);

        n4.left= n2;
        n4.right=n5;
        n2.left = n1;
        n2.right = n3;

        TreeToDoublyList t = new TreeToDoublyList();

        Node r = t.treeToDoublyList(n4);

    }
}
