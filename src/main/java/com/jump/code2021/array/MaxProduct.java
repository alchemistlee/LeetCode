package com.jump.code2021.array;

public class MaxProduct {

    public int maxProduct(int[] nums) {
        int maxProd = 0;

        for(int i=0;i<nums.length;i++){
            int tmpPath = nums[i];
            int lastFlow = -1;

            if(tmpPath> maxProd){
                maxProd = tmpPath;
            }

            for(int j=i+1;j<nums.length;j++){
                if(lastFlow==-1){
                    if(nums[j]-nums[j-1]==1){
                        lastFlow = 1;
                    }
                    else if(nums[j]-nums[j-1]==-1){
                        lastFlow = 0;
                    }
                    else{
                        break;
                    }
                    tmpPath*=nums[j];
                    if(tmpPath>maxProd){
                        maxProd = tmpPath;
                    }
                }
                else{
                    int curFlow = nums[j]-nums[j-1];
                    if(Math.abs(curFlow)==1 && curFlow == lastFlow){
                        tmpPath *= nums[j];
                        if(tmpPath>maxProd){
                            maxProd = tmpPath;
                        }
                    }
                    else{
                        break;
                    }
                }


            }

        }

        return maxProd;
    }

    public static void main(String[] args){
        int[] a = new int[]{-2,0,-1};
        MaxProduct m = new MaxProduct();
        int res = m.maxProduct(a);

        System.out.println(res);
    }
}
