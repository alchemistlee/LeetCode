package com.jump.leetcode.str;

/**
 * @author : alchemistlee on 2019/8/14
 * @version : 0.0.1
 **/

public class FirstUniChar {

    public static int firstUniqChar(String s) {
        for(int i=0;i<s.length();i++){
            boolean isUni = true;
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    isUni=false;
                    break;
                }
            }
            if(isUni){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
}
