package com.jump.leetcode.str;

/**
 * @author : alchemistlee on 2019/8/14
 * @version : 0.0.1
 **/

public class IsPalindrome {

    public static boolean isPalindrome(String s) {
        char[] sArr = s.toCharArray();
        StringBuffer sw1 = new StringBuffer();
        for(int i=0;i<sArr.length;i++){
            if(Character.isLetterOrDigit(sArr[i])){
                sw1.append(Character.toLowerCase(sArr[i]));
            }
        }
        String s1 = sw1.toString();
        StringBuffer sw2 = new StringBuffer();

        for(int i=s1.length()-1;i>=0;i--){
            sw2.append(s1.charAt(i));
        }

        String s2= sw2.toString();

        if(s1.equals(s2)){
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        String a ="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(a));
    }
}
