package com.jump.code2021.array;

public class MaxArea {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;

        int maxArea = Integer.MIN_VALUE;

        while (left<right){
            int curArea=0;

            if(height[right]<height[left]){
                curArea = height[right]*(right-left);
                right--;
            }
            else{
                curArea = height[left]*(right-left);
                left++;
            }

            if(curArea>maxArea){
                maxArea = curArea;
            }

        }

        return maxArea;
    }

    public static void main(String[] args){
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        MaxArea m = new MaxArea();
        System.out.println(m.maxArea(a));
    }
}
