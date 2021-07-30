package com.jump.code2021.linkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static private class ListNode {
        int val;
        int key;
        ListNode next;
        ListNode pre;
        ListNode() {}

    }

    private Map<Integer,ListNode> quicKMap;
    private ListNode head=null;
    private ListNode tail=null;
    private int capacity=0;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.quicKMap =new HashMap<>();
        this.head = new ListNode();
        this.tail=head;
    }

    public int get(int key) {
        if(quicKMap.containsKey(key)){
            ListNode tarNode=quicKMap.get(key);

            if(tarNode==tail){
                tail = tarNode.pre;
            }
            tarNode.pre.next = tarNode.next;
            tarNode.next = head.next;

            if(head.next!=null){
                head.next.pre =tarNode;
            }

            head.next = tarNode;
            tarNode.pre = head;

            return tarNode.val;
        }
        else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(quicKMap.containsKey(key)){
            ListNode tar = quicKMap.get(key);
            tar.val = value;

            if(tar==tail){
                tail=tar.pre;
            }

            tar.pre.next = tar.next;
            tar.next = head.next;
            head.next = tar;
            tar.pre = head;

        }
        else if(quicKMap.size()+1<=capacity){
            ListNode freshNode = new ListNode();
            freshNode.key= key;
            freshNode.val=value;

            if(head==tail){
                tail=freshNode;
            }

            freshNode.next=head.next;
            if(head.next!=null){
                head.next.pre = freshNode;
            }
            head.next=freshNode;
            freshNode.pre = head;

            quicKMap.put(key,freshNode);

        }
        else{
            ListNode delNode = tail;
            tail.pre.next= null;
            tail = tail.pre;

            delNode.pre = null;
            quicKMap.remove(delNode.key);

            put(key,value);

        }
    }

    public void printCache(){
        ListNode cur = head.next;
        System.out.println("-----print------");
        while (cur!=null){
            System.out.println(cur.key+" = "+cur.val);
            cur = cur.next;
        }
    }


    public static void main(String[] args){
        LRUCache lruCache =new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.printCache();
        lruCache.put(2, 2);
        lruCache.printCache();
        int a=lruCache.get(1);
        lruCache.printCache();
        lruCache.put(3, 3);
        lruCache.printCache();
        a= lruCache.get(2);    // 返回 -1 (未找到)
        System.out.println(a);
        lruCache.printCache();
        lruCache.put(4, 4);
        lruCache.printCache();
        a=lruCache.get(1);
        System.out.println(a);

    }

}
