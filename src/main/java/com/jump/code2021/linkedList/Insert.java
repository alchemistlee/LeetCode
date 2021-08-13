package com.jump.code2021.linkedList;

public class Insert {


    static private class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public Node insert(Node head, int insertVal) {
        if(head==null){
            return new Node(insertVal);
        }

        if(head.val>insertVal){
            //可能区域是前半场

            Node cur = head.next;


            while (true){

                if(cur.next.val<=head.val){
                    if(cur.next.val>=insertVal){
                        Node tmp = new Node(insertVal);
                        tmp.next = cur.next;
                        cur.next= tmp;
                        break;
                    }
                }

                cur = cur.next;

            }

        }
        else{
            //可能区域是后半场

            Node cur = head.next;
            while(true){

                if(cur.next.val > head.val){
                    if(cur.next.val>=insertVal){
                        Node tmp = new Node(insertVal);
                        tmp.next = cur.next;
                        cur.next=tmp;
                        break;
                    }
                }
                else{
                    Node tmp = new Node(insertVal);
                    tmp.next = cur.next;
                    cur.next=tmp;
                    break;
                }

                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args){
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n1=new Node(1);

        n3.next=n4;
        n4.next=n1;
        n1.next=n3;

        Insert i = new Insert();
        Node r = i.insert(n3,2);



    }
}
