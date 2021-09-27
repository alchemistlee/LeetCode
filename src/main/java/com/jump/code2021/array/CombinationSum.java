package com.jump.code2021.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrace(candidates,new ArrayList<>(), target);
        List<List<Integer>> res = new ArrayList<>();

        res.addAll(uniqMap.values());

        return res;
    }

    private Map<String,List<Integer>> uniqMap =new HashMap<>();


    private void backtrace(int[] candidates, List<Integer> track, int target ){

        int[] statRes = statComponent(track, candidates);
        int sumRes = sumComponent(statRes,candidates);

        if(sumRes>target){
            return;
        }
        else if(sumRes==target){
            String tmpK = encodeComponent(statRes);
            if(!uniqMap.containsKey(tmpK)){
                List<Integer> tmpTrack = new ArrayList<>();
                tmpTrack.addAll(track);
                uniqMap.put(tmpK, tmpTrack);
            }
            return;
        }

        for(int i=0;i<candidates.length;i++){
            track.add(candidates[i]);
            backtrace(candidates, track, target);
            track.remove(track.size()-1);
        }

    }


    private String encodeComponent(int[] comp){
        String k = "";
        for(int i=0;i<comp.length;i++){
            k+=comp[i];
        }
        return k;
    }

    private int[] statComponent(List<Integer> track, int[] candidates){
        Map<Integer,Integer> tmpCnt = new HashMap<>();
        for(int i=0;i<track.size();i++){
            if(!tmpCnt.containsKey(track.get(i))){
                tmpCnt.put(track.get(i),1);
            }
            else{
                Integer tmpInt = tmpCnt.get(track.get(i));
                tmpInt+=1;
                tmpCnt.put(track.get(i),tmpInt);
            }

        }

        int[] res = new int[candidates.length];

        for(int i=0;i<candidates.length;i++){
            if(tmpCnt.containsKey(candidates[i])){
                res[i] = tmpCnt.get(candidates[i]);
            }
            else{
                res[i] = 0;
            }
        }

        return res;
    }

    private int sumComponent(int[] comp, int[] candidates){
        int s = 0;
        for(int i=0;i<candidates.length;i++){
            s+= comp[i]*candidates[i];
        }
        return s;
    }

    public static void main(String[] args){
        CombinationSum c = new CombinationSum();
        int[] a = new int[]{2,3,5};
        int target = 8;

        List<List<Integer>> r = c.combinationSum(a,target);
    }
}
