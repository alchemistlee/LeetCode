package com.tigerye.leetcode.dynamicProgram;

/**
 * @author : alchemistlee on 2019/8/16
 * @version : 0.0.1
 **/

public class ClimbStairs {

    static int climbStairs(int n) {
        //f(n)=f(n-1)+f(n-2)
        //f(1) = 1
        //f(2)= 2
        if(n==1){
            return 1;
        }
        else if(n==2){
            return 2;
        }

        int t1 = climbStairs(n-1);
        int t2 = climbStairs(n-2);

        return t1+t2;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
