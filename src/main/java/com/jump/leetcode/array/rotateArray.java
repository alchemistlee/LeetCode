package com.jump.leetcode.array;

/**
 * @author : alchemistlee on 2019/8/13
 * @version : 0.0.1
 **/

public class rotateArray {

    public static int[] rotate(int[] nums, int k) {
        for(int i=0;i<k;i++){
            // begin to sub-rotate
            int tmp_val = 0 ;
            for(int j=nums.length-1;j>=0;j--){
                if(j==nums.length-1){
                    tmp_val=nums[nums.length-1];
                    continue;
                }
                int tgt_idx = (j+1)%nums.length;
                nums[tgt_idx] = nums[j];
            }
            nums[0] = tmp_val;
        }
        return nums;
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        int[] b = rotate(a,3);
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }

}
