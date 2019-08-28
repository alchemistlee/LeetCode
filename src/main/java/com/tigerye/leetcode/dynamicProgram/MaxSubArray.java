package com.tigerye.leetcode.dynamicProgram;

/**
 * @author : alchemistlee on 2019/8/19
 * @version : 0.0.1
 **/

public class MaxSubArray {


    static int maxSubArray(int[] nums) {
        int[] a = new int[nums.length];
        int max = 0;
        for(int i =0;i<nums.length;i++){
            if(i==0){
                a[0] = nums[0];
            }
            else {
                a[i] = Math.max(a[i - 1] + nums[i], nums[i]);
            }
            if(max<a[i]){
                max = a[i];
            }

        }

        return max;
    }

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
    }

}
