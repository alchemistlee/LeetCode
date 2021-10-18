package com.jump.code2021.array;

public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {


        for(int i=0;i<gas.length;i++){
            int start = i;
            int last = (i+1)%gas.length;
            int allGas = gas[i]-cost[i];

            while (start!=last && allGas>=0){

                allGas+=(gas[last]-cost[last]);
                last=(last+1)%gas.length;



            }

            if(start==last && allGas>=0){
                return start;
            }

        }

        return -1;

    }

    public static void main(String[] args){
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{3,4,5,1,2};

        CanCompleteCircuit cc = new CanCompleteCircuit();
        int r = cc.canCompleteCircuit(a,b);

        System.out.println(r);

    }
}
