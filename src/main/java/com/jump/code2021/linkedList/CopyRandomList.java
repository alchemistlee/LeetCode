package com.jump.code2021.linkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }



    public Node copyRandomList(Node head) {
        Node h1 =null;
        Map<Node,Node> m = new HashMap<>();
        if(head!=null){
            h1 = new Node(head.val);
            h1.random = head.random;
            m.put(head,h1);
        }
        else{
            return h1;
        }

        Node cur = head.next;
        Node cur1 = h1;


        while (cur!=null){
            Node dup =new Node(cur.val);
            dup.random= cur.random;

            m.put(cur,dup);
            cur1.next = dup;
            cur1 = dup;
            cur = cur.next;
        }

        Node cur2 = h1;
        while (cur2!=null){
            cur2.random = m.get(cur2.random);
            cur2 = cur2.next;
        }
        return h1;
    }

    public static void main(String[] args){
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        n1.random=null;
        n2.random=n1;
        n3.random=n5;
        n4.random=n3;
        n5.random=n1;

        CopyRandomList c=new CopyRandomList();
        Node res = c.copyRandomList(n1);
        System.out.println(res);

    }
}
