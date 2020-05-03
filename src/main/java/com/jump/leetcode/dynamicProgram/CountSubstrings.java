package com.jump.leetcode.dynamicProgram;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : alchemistlee on 2019/8/20
 * @version : 0.0.1
 **/

public class CountSubstrings {

    static int countSubstrings(String s) {
        int[] dp = new int[s.length()];
        List<Integer>  cur_loop_idx = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            if(i==0){
                dp[i] = 1;
                cur_loop_idx.add(i);
                continue;
            }
            int fresh_cnt = 0 ;
            List<Integer> tmp_cur= new ArrayList<>();
            for(int j=0;j<cur_loop_idx.size();j++){
                int tmp_idx = cur_loop_idx.get(j);
                if(tmp_idx-1 < 0 ){
                    continue;
                }
                if(s.charAt(tmp_idx-1)==s.charAt(i)){
                    fresh_cnt += 1;
                    tmp_cur.add(tmp_idx-1);
                }
            }
            cur_loop_idx.clear();
            cur_loop_idx.addAll(tmp_cur);

            dp[i]=fresh_cnt+1+dp[i-1];
            cur_loop_idx.add(i);

            if(s.charAt(i)==s.charAt(i-1)){
                dp[i]+=1;
                cur_loop_idx.add(i-1);
            }
        }
        return  dp[dp.length-1];
    }

    public static void main(String[] args) {
        String a ="abc";
        System.out.println(countSubstrings(a));
    }
}
