package com.tigerye.leetcode.str;

/**
 * @author : alchemistlee on 2019/8/14
 * @version : 0.0.1
 **/

public class ReverseStr {

    public static void reverseString(char[] s) {
        int l = s.length/2;
        for(int i=0;i<l;i++){
            char tmp = s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=tmp;
        }

        //print
        for(int i=0;i<s.length;i++){
            System.out.println(s[i]);
        }
    }

    public static void main(String[] args) {
        char[] a = {'h','e','l','l','o'};
        reverseString(a);
    }
}
