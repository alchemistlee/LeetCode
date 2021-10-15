package com.jump.code2021.array;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        quickSort(nums,0,nums.length-1);
        r= new ArrayList<>();
        uniq = new HashSet<>();

        for(int lev=1;lev<=nums.length;lev++) {
            backtrack(nums, lev, -1,new StringBuilder());
        }

        return r;
    }

    private List<List<Integer>> r ;
    private Set<String> uniq;

    private void backtrack(int[] nums, int level, int selectIdx, StringBuilder path){
        if(path.length()==level){
            String k = path.toString();
            if(!uniq.contains(k)){
                uniq.add(k);
                List<Integer> t1 = new ArrayList<>();
                for(int i=0;i<path.length();i++){
                    t1.add(Integer.valueOf(path.charAt(i)+""));
                }
                r.add(t1);
            }
            return;
        }
        StringBuilder tb = new StringBuilder();
        tb.append(path);

        for(int j=selectIdx+1;j<nums.length;j++){
            tb.append(nums[j]);
            backtrack(nums, level, j, tb);
            tb.deleteCharAt(tb.length()-1);
        }

    }

    private void quickSort(int[] n, int s, int e){
        if(s>e){
            return;
        }

        int high = e;
        int low =s;

        int m = n[low];

        int cur=high;

        while (low<high){

            if(cur==high) {
                if (m <= n[high]) {
                    high--;
                    cur = high;
                }
                else{
                    n[low] = n[high];
                    low++;
                    cur = low;
                }
            }
            else if(cur==low){
                if(m> n[low]){
                    low++;
                    cur = low;
                }
                else{
                    n[high] = n[low];
                    high--;
                    cur = high;
                }
            }

        }

        n[low] = m;

        quickSort(n,s,low-1);
        quickSort(n,low+1,e);

    }

    public static void main(String[] args){
        int[] a = new int[]{2,1,2};

        SubsetsWithDup s = new SubsetsWithDup();
        List<List<Integer>> r = s.subsetsWithDup(a);
    }
}
