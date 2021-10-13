package com.jump.code2021.array;

import java.util.ArrayList;
import java.util.List;

public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        r = new ArrayList<>();
        backtrack(n,0,k,new ArrayList<>());
        return r;
    }

    private List<List<Integer>> r ;

    private void  backtrack(int n , int s, int k, List<Integer> p){
        if(p.size()==k){
            List<Integer> t2 = new ArrayList<>();
            t2.addAll(p);
            r.add(t2);
            return;
        }

        List<Integer> tmp = new ArrayList<>();
        tmp.addAll(p);
        for(int i=s+1;i<=n;i++){
            tmp.add(i);
            backtrack(n,i,k,tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args){
        Combine c = new Combine();
        List<List<Integer>> res = c.combine(4,2);

    }
}
