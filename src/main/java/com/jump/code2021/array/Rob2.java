package com.jump.code2021.array;

public class Rob2 {
    public int rob(int[] nums) {
        int res = robIt(nums, 0, nums.length-1);
        return res;
    }


    private int robIt(int[] nums, int start, int end){
        if(start==end){
            return nums[start];
        }
        else if(start>end){
            return 0;
        }

        int robRev = 0;
        int noRobRev = 0;
        if(start==0){
            robRev = nums[start]+robIt(nums, start+2,end-1);
            noRobRev = robIt(nums, start+1,end);
        }
        else{
            robRev = nums[start]+robIt(nums, start+2, end);
            noRobRev = robIt(nums, start+1,end);
        }
        return Math.max(robRev,noRobRev);
    }


    public static void main(String[] args){
        int[] a = new int[]{1,2,3,1};
        Rob2 r = new Rob2();
        int res = r.rob(a);
        System.out.println(res);
    }

}
