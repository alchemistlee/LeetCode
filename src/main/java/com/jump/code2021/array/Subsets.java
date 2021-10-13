package com.jump.code2021.array;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        r =new ArrayList<>();
        r.add(new ArrayList<>());

        for(int j=0;j<nums.length;j++){
            backtrack(nums,-1,j+1,new ArrayList<>());
        }

        return r;
    }

    private List<List<Integer>> r;

    private void backtrack(int[] n, int selectedIdx, int level, List<Integer> p){
        List<Integer> t1 = new ArrayList<>();
        t1.addAll(p);

        if(p.size()==level){

            r.add(t1);
            return;
        }


        for(int i=selectedIdx+1;i<n.length;i++){
            t1.add(n[i]);
            backtrack(n,i,level,t1);
            t1.remove(t1.size()-1);
        }
    }

    public static void main(String[] args){
        int[] n = new int[]{1,2,3};

        Subsets ss = new Subsets();
        List<List<Integer>> r = ss.subsets(n);

    }
}
