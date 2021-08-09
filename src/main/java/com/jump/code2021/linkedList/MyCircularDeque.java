package com.jump.code2021.linkedList;

public class MyCircularDeque {


    static private class Node {
        int val;
        Node next;
        Node prev;
        Node() {}
        Node(int val) { this.val = val; }
    }

    private Node head;
    private Node tail;
    private int capacity=0;
    private int curCapacity=0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity=k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(curCapacity+1<=capacity){
            Node tmp= new Node(value);

            if(head==null){
                head=tmp;
                tail=tmp;
            }
            else{
                tmp.next = head;
                head.prev = tmp;
                head = tmp;
            }
            curCapacity+=1;
            return true;
        }
        return false;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(curCapacity+1<=capacity){
            Node tmp = new Node(value);
            if(tail==null){
                head=tmp;
                tail=tmp;
            }
            else{
                tail.next=tmp;
                tmp.prev=tail;
                tail=tmp;
            }
            curCapacity+=1;
            return true;
        }
        return false;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(head==null){
            return false;
        }


        if(head==tail){
            head=null;
            tail=null;
        }
        else{
            head.next.prev=null;
            head=head.next;
        }
        curCapacity-=1;
        return true;

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(tail==null){
            return false;
        }

        if(head==tail){
            head=null;
            tail=null;
        }
        else{
            tail.prev.next=null;
            tail = tail.prev;
        }
        curCapacity-=1;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(curCapacity==0){
            return -1;
        }
        return head.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(curCapacity==0){
            return -1;
        }
        return tail.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return curCapacity==0? true:false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return curCapacity==capacity ? true:false;
    }

    public static void main(String[] args){
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));			        // 返回 true
        System.out.println(circularDeque.insertLast(2));			        // 返回 true
        System.out.println(circularDeque.insertFront(3));			        // 返回 true
        System.out.println(circularDeque.insertFront(4));			        // 已经满了，返回 false
        System.out.println(circularDeque.getRear());  				// 返回 2
        System.out.println(circularDeque.isFull());				        // 返回 true
        System.out.println(circularDeque.deleteLast());			        // 返回 true
        System.out.println(circularDeque.insertFront(4));			        // 返回 true
        System.out.println(circularDeque.getFront());				// 返回 4
    }
}
