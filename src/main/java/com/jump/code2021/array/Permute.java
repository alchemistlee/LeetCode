package com.jump.code2021.array;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        allTracks = new ArrayList<>();

        backtrack(new ArrayList<>(),nums);

        return allTracks;
    }

    private List<List<Integer>> allTracks;

    private void backtrack(List<Integer> track, int[] candidates){

        if(track.size()==candidates.length){
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(track);
            allTracks.add(tmp);
            return;
        }

        for(int i=0;i<candidates.length;i++){
            if(track.contains(candidates[i])){
                continue;
            }

            track.add(candidates[i]);
            backtrack(track, candidates);
            track.remove(track.size()-1);

        }

    }




    public static void main(String[] args){
        int[] n = new int[]{1,2,3};

        Permute p = new Permute();
        List<List<Integer>> r = p.permute(n);

    }
}
