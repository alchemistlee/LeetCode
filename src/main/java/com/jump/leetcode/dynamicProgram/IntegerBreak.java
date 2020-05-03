package com.jump.leetcode.dynamicProgram;

/**
 * @author : alchemistlee on 2019/8/21
 * @version : 0.0.1
 **/

public class IntegerBreak {

    static int integerBreak(int n) {
        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            if(i==0){
                dp[i]=1;
                continue;
            }
            else if(i==1){
                dp[i]=1;
                continue;
            }

            int max_res =0;
            for(int j=0;j<i+1;j++){
                int left = j+1;
                int right = i+1 - left;
                if(left<i+1 && right>0){
                    int tmp = Math.max(left,dp[left-1])*Math.max(right,dp[right-1]);
                    if(tmp>max_res){
                        max_res=tmp;
                    }
                }
            }

            dp[i]=max_res;
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int a = 10;
        System.out.println(integerBreak(a));
    }
}
