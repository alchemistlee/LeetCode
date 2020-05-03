package com.jump.leetcode.array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : alchemistlee on 2019/8/13
 * @version : 0.0.1
 **/

public class RmDupFromSort {

    public static int removeDuplicates(int[] nums) {
        int nums_len = nums.length;
        for(int i=0;i<nums_len;i++){
            int j=i+1;
            int subDupLen = 0;
            for(;j<nums_len;j++){
                if(nums[i]!=nums[j]){
                    break;
                }
                else{
                    subDupLen+=1;
                }
            }


            for(int k=j;k<nums_len;k++){
                nums[k-subDupLen]=nums[k];
            }
            nums_len-=subDupLen;
        }
        int real_len = nums_len;
        //print
        for(int i=0;i<real_len;i++){
            System.out.println(nums[i]);
        }

        return real_len;


    }

    public static void main(String[] args){
        int[] a = {1,2,3,3,3,5,6,6,7,7,7,7,8};
        removeDuplicates(a);
    }
}

