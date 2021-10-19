package com.jump.code2021.array;

public class FindMin {

    public int findMin(int[] nums) {

        int lastNum=nums[nums.length-1];
        int i = nums.length-2 >=0 ? nums.length-2 : nums.length-2+nums.length;
        while (nums[i]<lastNum){
            lastNum = nums[i];
            i = i-1 >=0 ? i-1: i-1+nums.length;
        }
        return lastNum;
    }

    public static void main(String[] args){
        int[] a =new int[]{11,13,15,17};
        FindMin f = new FindMin();
        int r = f.findMin(a);
        System.out.println(r);
    }
}
