package com.tigerye.leetcode.array;

/**
 * @author : alchemistlee on 2019/8/13
 * @version : 0.0.1
 **/

public class plusOne {

    public static int[] plusOne(int[] digits) {
        int upVal = 1;
        for(int i=digits.length-1;i>=0;i--){
            int tmp = digits[i]+upVal;
            if(tmp>9){
                upVal=1;
                digits[i]=0;
            }
            else{
                digits[i]=tmp;
                break;
            }
        }

        if(digits[0]==0){
            int[] res = new int[digits.length+1];
            for(int i=0;i<res.length;i++){
                if(i==0){
                    res[i]=1;
                    continue;
                }
                res[i]=0;
            }
            return res;
        }
        return digits;
    }


    public static void main(String[] args){
        int[] a={1,9,9};
        int[] b= plusOne(a);
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }
}
