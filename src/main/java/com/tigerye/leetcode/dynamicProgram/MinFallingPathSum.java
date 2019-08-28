package com.tigerye.leetcode.dynamicProgram;

/**
 * @author : alchemistlee on 2019/8/21
 * @version : 0.0.1
 **/

public class MinFallingPathSum {

    static int minFallingPathSum(int[][] a) {
        int n = a.length;
        int[][] dp = new int[n][n];
        int min_sum = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    dp[i][j]=a[i][j];
                    continue;
                }
                dp[i][j]= a[i][j]+ dp[i-1][j];
                if(j-1>=0){
                    dp[i][j] = Math.min(dp[i][j], a[i][j]+dp[i-1][j-1]);
                }
                if(j+1<n){
                    dp[i][j]= Math.min(dp[i][j], a[i][j]+dp[i-1][j+1]);
                }
                if(i==n-1){
                    if(min_sum>dp[i][j]){
                        min_sum = dp[i][j];
                    }
                }
            }
        }
        return min_sum;
    }

    public static void main(String[] args) {
        int[][] a ={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(minFallingPathSum(a));
    }
}
