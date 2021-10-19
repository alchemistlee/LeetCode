package com.jump.code2021.array;

public class Rotate2 {
    public void rotate(int[] nums, int k) {
        int start=0;
        int target = (start+k)%nums.length;
        int startVal = nums[start];

        while (0!=target){
            int tmp = nums[target];
            nums[target] = startVal;

            start = target;
            target = (start+k)%nums.length;
            startVal = tmp;
        }
        nums[0] =startVal;

    }

    public static void main(String[] args){
        int[] a =new int[]{1,2,3,4,5,6,7};
        int k= 3;

        Rotate2 r2 = new Rotate2();
        r2.rotate(a,k);

    }
}
