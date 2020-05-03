package com.jump.leetcode.dynamicProgram;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : alchemistlee on 2019/8/22
 * @version : 0.0.1
 **/

public class WordBreak {

    static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];

        for(int i=0;i<dp.length;i++){
            if(i==0){
                dp[i] = true;
                continue;
            }
            boolean isSet = false;
            for(int j=0;j<i;j++){
                if(dp[j]){
                    String tmp = s.substring(j,i);
                    if(wordDict.contains(tmp)){
                        dp[i] = true;
                        isSet =true;
                        break;
                    }
                }
            }
            if(!isSet){
                dp[i] =false;
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {

        String s ="catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(wordBreak(s,wordDict));
    }
}
