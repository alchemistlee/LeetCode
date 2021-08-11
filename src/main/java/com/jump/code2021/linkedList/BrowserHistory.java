package com.jump.code2021.linkedList;

public class BrowserHistory {

    static private class ListNode {
        String val;
        ListNode next;
        ListNode prev;
        ListNode() {}
        ListNode(String val) { this.val = val; }
    }

    private ListNode head;
    private ListNode cur;


    public BrowserHistory(String homepage) {
        this.cur = new ListNode(homepage);
        this.head=this.cur;
    }

    public void visit(String url) {
        ListNode tmp = new ListNode(url);
        tmp.next=this.cur;
        this.cur.prev=tmp;
        this.cur = tmp;
        this.head = this.cur;
    }

    public String back(int steps) {
         while (this.cur.next!=null && steps>0){
             this.cur= this.cur.next;
             steps-=1;
         }

         return this.cur.val;
    }

    public String forward(int steps) {
        while (this.cur.prev!=null && steps>0){
            this.cur=this.cur.prev;
            steps-=1;
        }

        return this.cur.val;
    }

    public static void main(String[] args){
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"

        System.out.println(browserHistory.back(1));                   // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        System.out.println(browserHistory.back(1));                   // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        System.out.println(browserHistory.forward(1));                // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        System.out.println(browserHistory.forward(2));                // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        System.out.println(browserHistory.back(2));                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        System.out.println(browserHistory.back(7));                   // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"


    }

}
