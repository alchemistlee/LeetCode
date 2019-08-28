package com.tigerye.leetcode.str;

/**
 * @author : alchemistlee on 2019/8/14
 * @version : 0.0.1
 **/

public class CountAndSay {

    public static String countAndSay(int n) {

        String nStr = "1";
        for(int k=0;k<30;k++) {

            if(n-1==k){
                return nStr;
            }

            StringBuffer sw = new StringBuffer();

            for (int i = 0; i < nStr.length(); ) {
                char c = nStr.charAt(i);
                int sameLen = 1;
                for (int j = i + 1; j < nStr.length(); j++) {
                    if (c != nStr.charAt(j)) {
                        break;
                    } else {
                        sameLen += 1;
                    }
                }
                sw.append(sameLen);
                sw.append(c);
                i = i + sameLen;
            }
            nStr = sw.toString();
        }
        return "";
    }

    public static void main(String[] args) {
        int a =2;
        System.out.println(countAndSay(a));
    }
}
