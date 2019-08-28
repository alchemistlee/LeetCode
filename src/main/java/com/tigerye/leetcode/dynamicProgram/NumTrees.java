package com.tigerye.leetcode.dynamicProgram;

/**
 * @author : alchemistlee on 2019/8/20
 * @version : 0.0.1
 **/

public class NumTrees {

    static int numTrees(int n) {
        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            if(i==0){
                dp[i] = 1;
                continue;
            }
            dp[i]=0;
            for(int j = 0;j<i+1;j++){
                int left = j;
                int right = i+1-(j+1);
                int s = 1;
                if(left>0 ){
                    s *= dp[left-1];
                }
                if(right>0){
                    s *=dp[right-1];
                }
                dp[i]+=s;
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {

        int a = 3;
        System.out.println(numTrees(a));
    }
}
