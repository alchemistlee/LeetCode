package com.jump.leetcode.dynamicProgram;

/**
 * @author : alchemistlee on 2019/8/20
 * @version : 0.0.1
 **/

public class MinPathSum {

    static int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        for(int i=0;i<row;i++){

            for(int j=0;j<col;j++){
                if(i==0){
                    if(j==0){
                        dp[i][j]=grid[i][j];
                    }
                    else{
                        dp[i][j]=dp[i][j-1]+grid[i][j];
                    }
                }
                else{
                    if(j==0){
                        dp[i][j]=dp[i-1][j]+grid[i][j];
                    }
                    else{
                        dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                    }
                }

            }
        }

        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] a ={{1,3,1},
                {1,5,1},
                {4,2,1}};
        System.out.println(minPathSum(a));
    }
}
