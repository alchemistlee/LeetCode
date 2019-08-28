package com.tigerye.leetcode.dynamicProgram;

/**
 * @author : alchemistlee on 2019/8/19
 * @version : 0.0.1
 **/

public class Rob {

    static  int rob(int[] nums) {
        int[] f = new int[nums.length];

        if(nums.length<=2){
            return Math.max(nums[0],nums[1]);
        }
        f[0] = nums[0];
        f[1] = nums[1];
        for(int i=2;i<nums.length;i++){
            f[i] = Math.max(f[i-2]+nums[i],f[i-1]);
        }

        return f[f.length-1];
    }

    public static void main(String[] args) {
        int[] a = {2,7,9,3,1};
        System.out.println(rob(a));
    }
}
