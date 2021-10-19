package com.jump.code2021.array;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int res =0;
        for (int j =0;j<32;j++){

            int allSum = 0;

            for (int i = 0; i < nums.length; i++) {
                allSum += (nums[i]>>j) & 1 ;
            }

            if(allSum % 3!=0){
                res  = (1 << j) | res;
            }

        }

        return res;
//        for(int j=0;j<nums.length;j++){
//            if((allSum-nums[j])%3 == 0){
//                return nums[j];
//            }
//        }
//        return -1;
    }

    public static void main(String[] args){
        int[] a = new int[]{0,1,0,1,0,1,99};

        SingleNumber s = new SingleNumber();
        int r = s.singleNumber(a);

        System.out.println(r);
    }
}
