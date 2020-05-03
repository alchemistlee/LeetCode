package com.jump.leetcode.str;

/**
 * @author : alchemistlee on 2019/8/14
 * @version : 0.0.1
 **/

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        boolean isAllSame = true;
        int cur=0;
        StringBuffer sw = new StringBuffer();

        while(isAllSame){


            for(int i=0;i<strs.length;i++){
                if(strs[i].charAt(cur)!=strs[0].charAt(cur)){
                    isAllSame=false;
                    break;
                }
            }

            if(isAllSame){
                sw.append(strs[0].charAt(cur));
                cur+=1;
            }
        }
        return  sw.toString();
    }

    public static void main(String[] args) {
        String[] a={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(a));
    }
}
