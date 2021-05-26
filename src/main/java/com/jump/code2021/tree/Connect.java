package com.jump.code2021.tree;

public class Connect {


    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        connIt(root.left, root.right);
        return root;
    }

    public void  connIt(Node ln, Node rn){
        if(ln==null || rn == null){
            return;
        }

        ln.next = rn;

        connIt(ln.left,ln.right);
        connIt(ln.right,rn.left);
        connIt(rn.left,rn.right);


    }


    public static void  main(String[] args){
        Node r = new Node(1);
        Node n11 = new Node(2);
        Node n12 = new Node(3);
        Node n21 = new Node(4);
        Node n22 = new Node(5);
        Node n23 = new Node(6);
        Node n24 = new Node(7);

        r.left=n11;
        r.right=n12;
        n11.left=n21;
        n11.right=n22;
        n12.left=n23;
        n12.right=n24;



        Connect c = new Connect();
        c.connect(r);

        System.out.println(r);
    }
}
