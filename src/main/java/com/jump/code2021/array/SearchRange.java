package com.jump.code2021.array;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int left= leftBound(nums,target);

        int[] res = new int[2];

        if(left==-1){
            res = new int[]{-1,-1};
            return res;
        }

        res[0] = left;

        int i =left;

        for(;i<nums.length;i++){
            if(nums[i]!=nums[left]){
                break;
            }
        }
        res[1] = i-1;

        return res;
    }

    private int leftBound(int[] nums, int tar){
        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]<tar){
                left= mid+1;
            }
            else if(nums[mid]>tar){
                right = mid-1;
            }
            else{
                right = mid-1;
            }
        }

        if(left >= nums.length || nums[left]!=tar ){
            return -1;
        }
        return left;
    }

    public static void main(String[] args){
        SearchRange s = new SearchRange();
        int[] a = new int[]{5,7,7,8,8,10};
        int tar = 8;

        int[] b= s.searchRange(a,tar);

    }

}
