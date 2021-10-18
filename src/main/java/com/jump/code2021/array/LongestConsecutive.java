package com.jump.code2021.array;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> stat = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            stat.put(nums[i],1);
        }

        int maxPathLen = 0;

        for(int j=0;j<nums.length;j++){
            if(stat.containsKey(nums[j]-1)){
                continue;
            }
            int tmpPathLen=1;
            int k=1;
            while (true){
                if(stat.containsKey(nums[j]+k)){
                    tmpPathLen++;
                    k++;
                }
                else{
                    break;
                }
            }

            if(tmpPathLen>maxPathLen){
                maxPathLen = tmpPathLen;
            }

        }

        return maxPathLen;
    }


    public static void main(String[] args){
        int[] a = new int[]{100,4,200,1,3,2};
        LongestConsecutive l = new LongestConsecutive();
        int r = l.longestConsecutive(a);
        System.out.println(r);
    }
}
