package com.jump.code2021.array;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int[] sortNums = quickSort(nums,0, nums.length-1);

        int closestVal=Integer.MAX_VALUE;
        int[] tmp =null;

        for(int i=0;i<nums.length;i++){
            int k= nums.length-1;
            for(int j=i+1;j<nums.length && j<k ;j++){


                while(sortNums[i]+sortNums[j]+sortNums[k] > target && j<k){

                    if(Math.abs(sortNums[i]+sortNums[j]+sortNums[k]-target) < Math.abs(closestVal-target)){
                        closestVal = sortNums[i]+sortNums[j]+sortNums[k];
                        tmp=new int[]{i,j,k};
                    }
                    k--;
                }

                if(j>=k){
                    break;
                }

                if(Math.abs(sortNums[i]+sortNums[j]+sortNums[k]-target) < Math.abs(closestVal-target)){
                    closestVal = sortNums[i]+sortNums[j]+sortNums[k];
                    tmp=new int[]{i,j,k};
                }

            }

        }
        System.out.println(tmp);
        return  closestVal;
    }

    private int[] quickSort(int[] nums, int left, int right){
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
        ThreeSumClosest t = new ThreeSumClosest();
        int[] n = new int[]{-1,2,1,-4};
        int tar = 1;
        System.out.println(t.threeSumClosest(n,tar));
    }
}
