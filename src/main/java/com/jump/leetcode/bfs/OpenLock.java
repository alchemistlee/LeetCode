package com.jump.leetcode.bfs;

import java.util.*;

public class OpenLock {

    public List<String> getNeighbor(String node, Set<String> used){
        List<String> res = new ArrayList<String>();
        // char[] tmp = node.toCharArray();
        for(int i=0;i<4;i++){
            char[] tmp = node.toCharArray();
            char[] tmp2 = node.toCharArray();

            // char t= node.charAt(i);
//             int ti = Integer.parseInt(String.valueOf(t));
//             int next_t1 = (ti+1) % 10;
//             int next_t2 = (ti-1)<0 ? 9 : ti-1;
//             String[] bi_sub = new String[]{node.substring(0,i),node.substring(i+1) };

//             String st1= bi_sub[0]+ String.valueOf(next_t1) + bi_sub[1];
//             String st2 = bi_sub[0]+ String.valueOf(next_t2) +bi_sub[1];


            if(tmp[i]=='9'){
                tmp[i] = '0';
            }
            else{
                tmp[i]+=1;
            }

            String s1 = new String(tmp);

            if(tmp2[i] == '0'){
                tmp2[i] = '9';
            }
            else{
                tmp2[i] -= 1;
            }

            String s2 = new String(tmp2);

            if(!used.contains(s1)){
                res.add(s1) ;
            }

            if(!used.contains(s2)){
                res.add(s2) ;
            }
        }
        return res;
    }

    public int open(String[] deadends, String target) {
        Set<String> dead= new HashSet<String>(Arrays.asList(deadends));
        Queue<String> q = new LinkedList<String>();
        Set<String> used = new HashSet<String>();

        q.offer("0000");
        used.add("0000");

        int curSize = 1;
        int level = 0;

        while(q.size()>0){

            int tmpSize = 0;

            for(int i =0;i<curSize;i++){

                String item = q.poll();


                if(dead.contains(item)){
                    continue;
                }

                if(item.equals(target)){
                    return level;
                }



                List<String> neighbor= getNeighbor(item,used);

                for(String tn  : neighbor){
                    // String tn = neighbor[j];
                    // if(!used.contains(tn) && !dead.contains(tn)){
                    q.offer(tn);
                    used.add(item);
                    tmpSize +=1;
                    // }

                }

            }
            level+=1;

            curSize = tmpSize;
        }

        return -1;


    }


    public static void main(String[] args){

    }
}
