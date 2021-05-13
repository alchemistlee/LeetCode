package com.jump.leetcode.stack;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> data;
    private Stack<Integer> minNum;

    /** initialize your data structure here. */
    public MinStack() {
        this.data = new Stack<>();
        this.minNum = new Stack<>();


    }

    public void push(int x) {
        if(this.data.size()>0){
            Integer curMin = getMin();
            if(x>curMin){
                this.minNum.push(curMin);
                this.data.push(x);
            }
            else{
                this.minNum.push(x);
                this.data.push(x);
            }
        }
        else{
            this.minNum.push(x);
            this.data.push(x);
        }
    }

    public void pop() {
        if(this.data.size()>0){
            this.data.pop();
            this.minNum.pop();
        }
    }

    public int top() {
        if(this.data.size()>0){
            return this.data.peek();
        }
        return -1;
    }

    public int getMin() {
        if(this.data.size()>0){
            return this.minNum.peek();
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int a = minStack.getMin();  // --> 返回 -3.
        System.out.println(a);
        minStack.pop();
        a =minStack.top();      //--> 返回 0.
        System.out.println(a);

        a= minStack.getMin();
        System.out.println(a);

    }

}
