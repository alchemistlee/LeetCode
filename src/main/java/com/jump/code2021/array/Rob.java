package com.jump.code2021.array;

public class Rob {

    public int rob(int[] nums) {
        int res = robIt(nums,0);
        return res;
    }

    private int robIt(int[] nums, int startIdx){
        if(startIdx==nums.length-1){
            return nums[startIdx];
        }
        else if(startIdx>nums.length-1){
            return 0;
        }

        int robRev = nums[startIdx]+ robIt(nums, startIdx+2);
        int noRobRev =  robIt(nums, startIdx+1);

        return Math.max(robRev, noRobRev);
    }

    public static void main(String[] args){
        int[] a = new int[]{2,7,9,3,1};
        Rob rob = new Rob();
        int res = rob.rob(a);
        System.out.println(res);
    }
}
