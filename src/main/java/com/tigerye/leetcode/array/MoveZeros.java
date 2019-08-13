package com.tigerye.leetcode.array;

/**
 * @author : alchemistlee on 2019/8/13
 * @version : 0.0.1
 **/

public class MoveZeros {

    public static int[] moveZeroes(int[] nums) {
        int firstZeroIdx = -1;
        for(int i=0;i<nums.length;i++){
            if(firstZeroIdx==-1){
                if(nums[i]==0){
                    firstZeroIdx=i;
                }
            }
            else{
                if(nums[i]==0){
                    continue;
                }
                else{
                    nums[firstZeroIdx]=nums[i];
                    nums[i]=0;
                    firstZeroIdx+=1;
                }
            }

        }
        return nums;
    }

    public static void main(String[] args){
        int[] a={0,1,0,3,12};
        int[] b= moveZeroes(a);
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }
}
