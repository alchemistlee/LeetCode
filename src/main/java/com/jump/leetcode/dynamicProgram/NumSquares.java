package com.jump.leetcode.dynamicProgram;

/**
 * @author : alchemistlee on 2019/8/21
 * @version : 0.0.1
 **/

public class NumSquares {


    static int numSquares(int n) {

        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            int tar_num = i+1;
            int max_nature_base = (int) Math.floor(Math.pow(tar_num,0.5));
            int min_cnt = Integer.MAX_VALUE;
            for(int j=max_nature_base;j>0;j--){
                int tmp_sub = j*j;
                int tmp_res = tar_num - tmp_sub;
                if(tmp_res==0){
                    min_cnt = 1;
                    break;
                }
                else{
                    min_cnt = Math.min(min_cnt,dp[tmp_res-1]+1);
                }
            }
            dp[i]=min_cnt;
        }

        return dp[n-1];

    }

    public static void main(String[] args) {

//        int b  = (int)Math.floor(Math.pow(2,0.5));
//        System.out.println(b);

        int a =13;
        System.out.println(numSquares(a));
    }

}
