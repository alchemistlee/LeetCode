package com.jump.leetcode.dynamicProgram;

/**
 * @author : alchemistlee on 2019/8/19
 * @version : 0.0.1
 **/

public class SumRange {

    private int[] sum ;

    public SumRange(int[] nums) {
        this.sum = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                this.sum[0]= nums[0];
                continue;
            }
            this.sum[i]=this.sum[i-1]+nums[i];
        }

    }

    public int sumRange(int i, int j) {
        if(i>=1){
            return this.sum[j]-this.sum[i-1];
        }
        return this.sum[j];
    }


    public static void main(String[] args){
        int[] a= {-2, 0, 3, -5, 2, -1};
        SumRange b = new SumRange(a);
        System.out.println(b.sumRange(2,5));
    }
}
