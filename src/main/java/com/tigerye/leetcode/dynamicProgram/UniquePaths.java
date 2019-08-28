package com.tigerye.leetcode.dynamicProgram;

/**
 * @author : alchemistlee on 2019/8/21
 * @version : 0.0.1
 **/

public class UniquePaths {

    static  int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    if(j==0){
                        dp[i][j]=1;
                    }
                    else{
                        dp[i][j]=dp[i][j-1];
                    }
                }
                else if(j==0){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }



    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }
}
