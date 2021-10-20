package com.jump.code2021.array;

import java.util.Arrays;

public class CountPrimes {

    public int countPrimes(int n) {
        int[] isPrime =  new int[n];
        Arrays.fill(isPrime,1);

        int cnt = 0;
        for(int i=2;i<n;i++){
            if(isPrime[i]==1){
                cnt+=1;
                for(int j= i*i;j<n;j+=i){
                    isPrime[j]=0;
                }

            }


        }
        return cnt;
    }

    public static void main(String[] args){
        CountPrimes c = new CountPrimes();
        int r = c.countPrimes(10);

        System.out.println(r);
    }
}
