package com.jump.code2021.array;

public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int right = 0;

        int res = Integer.MAX_VALUE;

        int windowSum = 0;

        while (right<nums.length){
            windowSum+=nums[right];

            while (windowSum>=target){
                int len = right-left +1;
                if(len<res){
                    res = len;
                }

                windowSum-= nums[left++];


            }

            right++;



        }

        return res;

    }

    public static void main(String[] args){
        int[] a=new int[]{2,3,1,2,4,3};
        int tar = 7;
        MinSubArrayLen m = new MinSubArrayLen();
        int res =m.minSubArrayLen(tar, a);
        System.out.println(res);
    }

}
