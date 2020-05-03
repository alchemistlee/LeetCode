package com.jump.leetcode.str;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : alchemistlee on 2019/8/14
 * @version : 0.0.1
 **/

public class IsAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s.equals(t)){
           return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        if(sArr.length!=tArr.length){
            return false;
        }

        for(int i=0;i<sArr.length;i++){
            if(sArr[i]!=tArr[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s="anagram";
        String t="nagaram";
        System.out.println(isAnagram(s,t));
    }
}
