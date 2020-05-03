package com.jump.leetcode.dynamicProgram;

/**
 * @author : alchemistlee on 2019/8/19
 * @version : 0.0.1
 **/

public class MinCostClimbingStairs {

    static int minCostClimbingStairs(int[] cost) {
        int[] f = new int[cost.length];
        f[0] = cost[0];
        f[1] = cost[1];

        for(int i=2;i<cost.length;i++){
            f[i] = Math.min(cost[i]+f[i-1],cost[i]+f[i-2]);
        }

        return f[f.length-1];
    }

    public static void main(String[] args){
        int[] a = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(a));
    }
}
