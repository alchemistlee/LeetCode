package com.tigerye.leetcode.dynamicProgram;

/**
 * @author : alchemistlee on 2019/8/20
 * @version : 0.0.1
 **/

public class StoneGame {

    static class Pair{
        int fir;
        int sec;

    }

    static boolean stoneGame(int[] piles) {
        Pair[][] dp = new Pair[piles.length][piles.length];

        for(int j=0;j<piles.length;j++){

            for(int i=0,k=j;i<piles.length && k<piles.length;i++,k++){
                dp[i][k] = new Pair();
                if(i==k){

                    dp[i][k].fir = piles[i];
                    dp[i][k].sec = 0;
                    continue;
                }
                if(dp[i+1][k].sec + piles[i] > dp[i][k-1].sec+piles[k]){

                    dp[i][k].fir = dp[i+1][k].sec+piles[i];
                    dp[i][k].sec = dp[i+1][k].fir;
                }
                else{
                    dp[i][k].fir = dp[i][k-1].sec+piles[k];
                    dp[i][k].sec = dp[i][k-1].fir;
                }
            }
        }

        if(dp[0][piles.length-1].fir>dp[0][piles.length-1].sec){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {

        int[] a ={5,3,4,5};
        System.out.println(stoneGame(a));
    }
}
