package com.jump.code2021.array;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        nums = quickSort(nums,0,nums.length-1);

        int n = nums.length;
        for(int first = 0; first< n;first++){
            int third = n-1;
            for(int second= first+1;second<n ; second++){
                if(second != first+1 && nums[second]==nums[second-1]){
                    continue;
                }

                while (nums[first]+nums[second]+nums[third]>0){
                    third--;
                }

                if(second>=third){
                    break;
                }
                if(nums[first]+nums[second]+nums[third]==0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[first]);
                    tmp.add(nums[second]);
                    tmp.add(nums[third]);
                    res.add(tmp);
                }

            }

        }

        return res;
    }

    private int[] quickSort(int[] nums,int left, int right){

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
        int[] a =new int[]{-1,0,1,2,-1,-4};
        ThreeSum t = new ThreeSum();
        List<List<Integer>> r = t.threeSum(a);

    }
}
