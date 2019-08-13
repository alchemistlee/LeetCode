package com.tigerye.leetcode.array;

/**
 * @author : alchemistlee on 2019/8/13
 * @version : 0.0.1
 **/

public class findSingle {

    public static int singleNumber(int[] nums) {
        int baseNum=0;
        for(int num : nums){
            baseNum = baseNum ^ num;
        }
        return baseNum;
    }

    public static void main(String[] args){
        //TODO
        int[] a={4,1,2,1,2};
        System.out.println(singleNumber(a));
    }
}
