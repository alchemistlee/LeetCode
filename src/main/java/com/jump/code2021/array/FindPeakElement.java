package com.jump.code2021.array;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l =0;
        int r =nums.length-1;

        while (l<r){

            int mid = (l+r)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(nums[mid]>nums[mid+1]){
                r=mid-1;
            }
            else if(nums[mid]<nums[mid+1]){
                l=mid+1;
            }
        }

        return l;
    }

    public static void main(String[] args){
        int[] a =new int[]{1,2,1,3,5,6,4};
        FindPeakElement f = new FindPeakElement();
        int r = f.findPeakElement(a);
        System.out.println(r);
    }
}
