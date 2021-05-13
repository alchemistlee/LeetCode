package com.jump.leetcode.stack;

import java.util.Stack;

public class ValidScope {

    public  boolean isCouple(String l, String r){
        if(l.equals("{")){
            if(r.equals("}")){
                return true;
            }
            return false;
        }

        else if(l.equals("[")){
            if(r.equals("]")){
                return true;
            }
            return false;
        }
        else{
            if(r.equals(")")){
                return true;
            }
            return false;
        }
    }


    public boolean isValid(String s) {
        Stack<String> d = new Stack<>();



        for(int i=0;i<s.length();i++){
            String t = String.valueOf(s.charAt(i));

            if(d.size()>0){
                String exit_left = d.peek();
                if(isCouple(exit_left,t)){
                    d.pop();
                }
                else{
                    d.push(t);
                }
            }
            else{
                d.push(t);
            }
        }

        if(d.size()>0){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        ValidScope a = new ValidScope();
        System.out.println(a.isValid("{[]}"));
    }
}
