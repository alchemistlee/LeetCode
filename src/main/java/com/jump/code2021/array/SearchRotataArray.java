package com.jump.code2021.array;

public class SearchRotataArray {

    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        if(nums[0]<= target){

            while (left<=right){
                int mid = left + (right-left)/2;

                if(nums[mid]==target){
                    return mid;
                }

                if(nums[mid]>target|| nums[mid]<nums[0]){
                    right=mid-1;
                }
                else{
                    left =mid+1;
                }

            }
        }
        else{

            while (left<=right){
                int mid= left + (right-left)/2;
                if(nums[mid] == target){
                    return mid;
                }

                if(nums[mid]<target|| nums[mid]>nums[0]){
                    left = mid+1;
                }
                else{
                    right=mid-1;
                }

            }

        }
        return -1;
    }

    public static void main(String[] args){
        int[] a = new int[]{4,5,6,7,0,1,2};
        int tar = 2;

        SearchRotataArray s = new SearchRotataArray();
        System.out.println(s.search(a,tar));
    }
}
