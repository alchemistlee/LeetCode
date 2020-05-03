package com.jump.leetcode.array;

/**
 * @author : alchemistlee on 2019/8/13
 * @version : 0.0.1
 **/

public class MaxStockProfit {

    public static int maxProfit(int[] prices){
        int sum = 0;

        for(int i=0;i<prices.length;){
            int max_idx=i;
            for(int j=i+1;j<prices.length;j++){
                if(prices[max_idx]<=prices[j]){
                    max_idx=j;
                    continue;
                }
                else{
                    break;
                }
            }
            if(i==max_idx){
                i+=1;
                continue;
            }
            else{
                sum += prices[max_idx]-prices[i];
                i=max_idx+1;
            }
        }

        return sum;
    }

    public static void main(String[] args){
        int[] a = {7,6,4,3,1};
        System.out.println(maxProfit(a));
    }
}
