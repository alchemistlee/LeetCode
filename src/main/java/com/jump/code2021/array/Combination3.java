package com.jump.code2021.array;

import java.util.ArrayList;
import java.util.List;

public class Combination3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        pathLen = k;
        pathTar = n;
        pathSet = new ArrayList<>();

        List<Integer> candidate = new ArrayList<>();
        for(int i=1;i<=9;i++){
            candidate.add(i);
        }
        backtrack(candidate, new ArrayList<>(), 0);
        return pathSet;
    }

    private int pathLen;
    private int pathTar;
    private List<List<Integer>> pathSet;

    private void backtrack(List<Integer> candidate, List<Integer> path , int pathSum){
        if(path.size()==pathLen){
            if(pathSum==pathTar){
                List<Integer> t1 = new ArrayList<>();
                t1.addAll(path);
                pathSet.add(t1);
            }
            return;
        }

        List<Integer> tmp = new ArrayList<>();
        tmp.addAll(path);
        for(int i=0;i<candidate.size();i++){
            tmp.add(candidate.get(i));
            List<Integer> tmpCandidate =new ArrayList<>();
            tmpCandidate.addAll(candidate);
            tmpCandidate.remove(i);
            backtrack(tmpCandidate,tmp,pathSum+candidate.get(i));
            tmp.remove(tmp.size()-1);
        }


    }


    public static void main(String[] args){
        Combination3 c3 = new Combination3();
        List<List<Integer>> r = c3.combinationSum3(3,7);

    }
}
