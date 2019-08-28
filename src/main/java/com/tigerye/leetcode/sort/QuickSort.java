package com.tigerye.leetcode.sort;

public class QuickSort {

    static void myQuickSort(int[] input,int low,int high){
        int start = low;
        int end = high;
        if(start==end || start>end){
            return ;
        }
        int tmp = input[low];
        boolean cmpHigh = true;
        while (low<high){
            if(cmpHigh) {
                if (input[high] > tmp) {
                    high -= 1;
                }
                else{
                    input[low]=input[high];
                    cmpHigh=false;
                }
            }
            else{
                if(input[low]<=tmp){
                    low+=1;
                }
                else{
                    input[high] = input[low];
                    cmpHigh=true;
                }
            }
        }
        input[low] = tmp;
        myQuickSort(input,start,low-1);
        myQuickSort(input,low+1,end);
    }

    public static void main(String[] args){
        int[] a ={2,4,5,1,7};
        myQuickSort(a,0,a.length-1);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
