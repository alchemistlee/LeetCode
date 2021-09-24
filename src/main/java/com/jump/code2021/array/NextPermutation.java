package com.jump.code2021.array;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int left = -1;

        for(int i=nums.length-2;i>=0;i--){
            int j=i+1;
            if(nums[i]<nums[j]){
                left = i;
                break;
            }
        }

        if(left!=-1){
            int right = -1;
            for(int j=nums.length-1;j>left;j--){
                if(nums[j]>nums[left]){
                    right=j;
                    break;
                }
            }

            swap(nums,left,right);
            reverse(nums,left+1,nums.length-1);

        }
        else{
            reverse(nums,0,nums.length-1);
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int s, int e){
        int l =s;
        int r =e;

        while (l<r){
            int tmp=nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args){
        int[] a= new int[]{1,2,3};

        NextPermutation n = new NextPermutation();
        n.nextPermutation(a);
    }
}
