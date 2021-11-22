package com.jump.code2021.square;

public class FindCycle {

    class Node{
        public int value;
        public Node next;

        public Node(){
        }

    }

    private Node  findCycle(Node head){
        if(head==null || head.next==null){
            return null;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast!=null && fast.next!=null){

            if(slow == fast ){
                break;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast==slow){
            slow = head ;
            while (fast!=slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
        return null;
    }

    public static void main(String[] args){

    }
}
