package com.jump.code2021.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        tracks=new HashMap<>();

        backtrack(new ArrayList<>(),nums);

        List<List<Integer>> tmp = new ArrayList<>();

        tmp.addAll(tracks.values());

        return tmp;
    }

    private Map<String,List<Integer>> tracks;

    private void backtrack(List<Integer> track, int[] candidates){

        if(candidates.length==0){
            String k = encode(track);
            if(!tracks.containsKey(k)){

                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(track);
                tracks.put(k,tmp);
            }
            return;
        }

        for(int i=0;i<candidates.length;i++){
            track.add(candidates[i]);
            int[] freshCandidates = mask(candidates,i);
            backtrack(track, freshCandidates);
            track.remove(track.size()-1);
        }

    }

    private int[] mask(int[] ori, int m){
        int[] r = new int[ori.length-1];
        for(int i=0,j=0;i<ori.length;i++){
            if(i==m){
                continue;
            }
            else{
                r[j]=ori[i];
                j++;
            }
        }
        return r;
    }

    private String encode(List<Integer> t){
        StringBuilder sb= new StringBuilder();
        for(Integer i :t){
            sb.append(i);
        }

        return sb.toString();
    }


    public static void main(String[] args){
        int[] a = new int[]{1,2,3};
        PermuteUnique pu = new PermuteUnique();
        List<List<Integer>> t = pu.permuteUnique(a);

    }
}
