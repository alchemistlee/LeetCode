package com.jump.leetcode.array;

/**
 * @author : alchemistlee on 2019/8/13
 * @version : 0.0.1
 **/

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] res ={-1,-1};
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                    return res;
                }
            }
        }

        return res;

    }

    public static void main(String[] args){
        int[] a={2, 11, 7, 15};
        int[] b= twoSum(a,9);
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }
}
