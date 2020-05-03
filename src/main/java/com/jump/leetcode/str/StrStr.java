package com.jump.leetcode.str;

/**
 * @author : alchemistlee on 2019/8/14
 * @version : 0.0.1
 **/

public class StrStr {
    public static int strStr(String haystack, String needle) {
        for(int i=0;i<=haystack.length()-needle.length();i++){
            boolean isAllRight = true;
            for(int j=0,c=i;j<needle.length();j++,c++){
                if(haystack.charAt(c)!=needle.charAt(j)){
                    isAllRight = false;
                    break;
                }
            }
            if(isAllRight){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a="aaaaa";
        String b="bba";
        System.out.println(strStr(a,b));

    }
}
