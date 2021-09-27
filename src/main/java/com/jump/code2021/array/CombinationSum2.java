package com.jump.code2021.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        backtrace(candidates, new ArrayList<>(), target);

        List<List<Integer>> r = new ArrayList<>();

        r.addAll(stat.values());

        return r;

    }


    private Map<String,List<Integer>> stat= new HashMap<>();

    private void backtrace(int[] candidates, List<Integer> trace, int target){

        int sumTra = sumTrace(trace);
        if(sumTra>target){
            return;
        }
        else if(sumTra==target){

            List<Integer> tmpTrace = new ArrayList<>();
            tmpTrace.addAll(trace);

            quickSort(tmpTrace,0,tmpTrace.size()-1);
            String k = encode(tmpTrace);
            if(!stat.containsKey(k)){
                stat.put(k,tmpTrace);
            }
            return;
        }

//        List<Integer> tmpTrace = new ArrayList<>();
//        tmpTrace.addAll(trace);


        for(int i=0;i<candidates.length;i++){


            trace.add(candidates[i]);
            int[] tmpCandidates =  mask(candidates, i);

            backtrace(tmpCandidates, trace, target);

            trace.remove(trace.size()-1);
        }
    }

    private int[] mask(int[] candidates, int rmIdx){
        int[] r = new int[candidates.length-1];

        for(int i=0,j=0;i<candidates.length;i++){
            if(i==rmIdx){
                continue;
            }
            else{
                r[j]=candidates[i];
                j++;
            }

        }
        return r;
    }

    private int sumTrace(List<Integer> trace){
        int res = 0;
        for(Integer t : trace){
            res += t;
        }
        return res;
    }

    private void quickSort(List<Integer> t, int start, int end){


        if(start>=end){
            return;
        }
        int cur = end;

        for(int i=start;i<=end;i++){
            if(t.get(i)>=t.get(cur)){
                if(i<cur){
                    int tmp = t.get(cur);
                    t.set(cur, t.get(i));
                    t.set(i,tmp);
                    cur = i;
                }
                else if(i>cur){
                    continue;
                }
                else{
                    continue;
                }

            }
            else{
                if(i<cur){
                    continue;
                }
                else if(i>cur){
                    int tmp = t.get(cur);
                    t.set(cur, t.get(i));
                    t.set(i,tmp);
                    cur = i;
                }
                else{
                    continue;
                }
            }
        }


        quickSort(t,start,cur-1);
        quickSort(t,cur+1,end);
    }

    private String encode(List<Integer> t ){
        String k = "";
        for(int i=0;i<t.size();i++){
            k+=t.get(i);
        }
        return k;
    }



    public static void main(String[] args){
        int[] a=new int[]{10,1,2,7,6,1,5};
        int b = 8;

        CombinationSum2 c = new CombinationSum2();
        List<List<Integer>> r = c.combinationSum2(a,b);

    }
}
