package com.tigerye.leetcode.str;

/**
 * @author : alchemistlee on 2019/8/14
 * @version : 0.0.1
 **/

public class ReverseInt {

    public static int reverse(int x){
        int res = 0;
        while (x!=0){
            int last = x%10;
            int left = x/10;
            res = res*10 + last;
            if(res > Math.pow(2,31)-1 || res< Math.pow(2,32)*-1){
                return 0;
            }
            x=left;

        }

        return res;

    }

    public static void main(String[] args) {
        int a =-123;
        System.out.println(reverse(a));
    }
}
