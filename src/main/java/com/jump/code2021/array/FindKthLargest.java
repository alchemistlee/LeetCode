package com.jump.code2021.array;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int res = findKth(nums, 0, nums.length-1,k);
        return res;
    }

    private int findKth(int[] n, int start, int end, int k){

        if((end-start+1)<k){
            return -1;
        }

        int left= start;
        int right = end;
        int mid = left;
        int midVal = n[mid];

        int cur=right;

        while (left<right){
            if(cur==right){
                if(n[right]>=midVal){
                    right--;
                    cur = right;
                }
                else{
                    n[left] = n[right];
                    left++;
                    cur = left;
                }
            }
            else{
                if(n[left]<midVal){
                    left++;
                    cur = left;
                }
                else{
                    n[right]= n[left];
                    right--;
                    cur = right;
                }
            }
        }

        n[left] = midVal;

        int rightSize = end-left;
        if(rightSize==k-1){
            return midVal;
        }
        else if(rightSize<k-1){
            return findKth(n, start, left-1,k-rightSize-1);
        }
        else{
            return findKth(n,left+1,end,k);
        }

    }

    public static void  main(String[] args){
        int[] a = new int[]{3,2,3,1,2,4,5,5,6};
        int b =4;
        FindKthLargest f =  new FindKthLargest();
        int r = f.findKthLargest(a,b);
        System.out.println(r);
    }
}
