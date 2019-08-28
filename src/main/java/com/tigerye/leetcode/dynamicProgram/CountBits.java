package com.tigerye.leetcode.dynamicProgram;

/**
 * @author : alchemistlee on 2019/8/20
 * @version : 0.0.1
 **/

public class CountBits {

    static int[] countBits(int num) {
        int[] res = new int[num+1];

        for(int i =0;i<res.length;i++){
            if(i==0){
                res[i]=0;
                continue;
            }

            if(i%2==1){
                res[i] = res[i-1]+1;
            }
            else{
                res[i] = res[i/2];
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int a = 5;
        int[] b = countBits(a);
        for (int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }
}
