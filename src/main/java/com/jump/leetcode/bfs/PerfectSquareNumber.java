package com.jump.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
完全平方数
 */
public class PerfectSquareNumber {


    public List<Integer> getNeighbor(int base, int uplimit){
        List<Integer> res = new ArrayList<Integer>();
        for(int i=1;i<uplimit;i++){
            int sn = i*i;
            int nn = base+sn;
            if(nn <= uplimit){
                res.add(nn);
            }
            else{
                break;
            }
        }
        return res;
    }

    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<Integer>();

        List<Integer> init = getNeighbor(0, n);

        for(Integer number : init){
            q.offer(number);
        }

        int curSize = init.size();
        int level = 0;
        while(q.size()>0){
            int tmpSize = 0;
            for(int i=0;i<curSize;i++){
                Integer item  = q.poll();

                if(item.equals(n)){
                    return level+1;
                }
                List<Integer> tmpNeighbor = getNeighbor(item.intValue(),n);
                for(Integer nu : tmpNeighbor){
                    q.offer(nu);
                    tmpSize+=1;
                }
            }

            curSize = tmpSize;
            level+=1;
        }
        return -1;
    }

    public static void main(String[] args){
        PerfectSquareNumber a= new PerfectSquareNumber();
        int b= a.numSquares(13);

        System.out.println(b);

    }
}
