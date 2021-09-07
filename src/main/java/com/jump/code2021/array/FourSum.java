package com.jump.code2021.array;

import java.util.ArrayList;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        nums =  quickSort(nums, 0, nums.length-1);


        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<nums.length;i++){

            for(int j=i+1;j<nums.length;j++){

                int l= nums.length-1;
                for(int k=j+1;k<nums.length && k<l;k++){

                    while (nums[i]+nums[j]+nums[k]+nums[l]>target){
                        l--;
                    }

                    if(k>=l){
                        break;
                    }

                    if(nums[i]+nums[j]+nums[k]+nums[l]==target){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        tmp.add(nums[l]);
                        res.add(tmp);
                    }

                }

            }
        }

        return res;

    }

    private  int[] quickSort(int[] nums, int left, int right){
        if(left>=right){
            return null;
        }

        int mid= left + (right-left)/2;

        for(int i=left;i<=right;i++){
            if(i==mid){
                continue;
            }
            else if(i<mid){
                if(nums[i]>nums[mid]){
                    int tmp = nums[mid];
                    nums[mid]= nums[i];
                    nums[i]= tmp;
                    mid = i;
                }
            }
            else if(i>mid){
                if(nums[i]<nums[mid]){
                    int tmp = nums[mid];
                    nums[mid]= nums[i];
                    nums[i]=tmp;
                    mid =i;
                }
            }

        }

        quickSort(nums,left,mid-1);
        quickSort(nums,mid+1,right);

        return nums;
    }



    public static void main(String[] args){
        int[] n = new int[]{1,0,-1,0,-2,2};
        int tar = 0;

        FourSum f = new FourSum();
        List<List<Integer>> r = f.fourSum(n,tar);

    }
}
