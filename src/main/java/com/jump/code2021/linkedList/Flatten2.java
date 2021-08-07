package com.jump.code2021.linkedList;

public class Flatten2 {

    static private class Node {
        public int val;
        public Node next;
        public Node prev;
        public Node child;
        Node() {}
        Node(int val) { this.val = val; }

    }

    public Node flatten(Node head) {
        if(head==null){
            return null;
        }

        flattenIt(head);

        return head;
    }


    private Node flattenIt(Node h){
        Node cur = h;
        Node pre = null;

        while (cur!=null){

            Node nextTmp = cur.next;

            if(cur.child!=null){
                Node cTail= flattenIt(cur.child);
                cur.next = cur.child;
                cur.child.prev = cur;
                cTail.next= nextTmp;
                nextTmp.prev = cTail;

                cur.child =null;
            }

            pre = cur;
            cur =nextTmp;
        }
        return pre;
    }


    public static void main(String[] args){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;

        n7.next=n8;
        n8.next=n9;
        n9.next=n10;

        n11.next=n12;

        n2.prev=n1;
        n3.prev=n2;
        n4.prev=n3;
        n5.prev=n4;
        n6.prev=n5;

        n10.prev=n9;
        n9.prev=n8;
        n8.prev=n7;

        n12.prev=n11;

        n3.child=n7;

        n8.child=n11;

        Flatten2 f =new Flatten2();
        Node r= f.flatten(n1);
    }
}
