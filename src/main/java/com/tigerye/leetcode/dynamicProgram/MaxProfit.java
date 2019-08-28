package com.tigerye.leetcode.dynamicProgram;

/**
 * @author : alchemistlee on 2019/8/19
 * @version : 0.0.1
 **/

public class MaxProfit {

    static int maxProfit(int[] prices) {
        int[] max_profit = new int[prices.length];
        int min_price = 0;
        int res = 0;
        for(int i=0;i<prices.length;i++){
            if(i==0){
                max_profit[i]=0;
                min_price = prices[i];
                continue;
            }
            max_profit[i] =Math.max(max_profit[i-1], prices[i]-min_price);
            if(res<max_profit[i]){
                res = max_profit[i];
            }
            if(prices[i]<min_price){
                min_price = prices[i];
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] a = {7,6,4,3,1};
        int b = maxProfit(a);
        System.out.println(b);
    }
}
