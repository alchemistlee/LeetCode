package com.jump.code2021.array;

import java.util.HashMap;
import java.util.Map;

public class SortColors {

    public void sortColors(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>();

        m.put(0,0);
        m.put(1,0);
        m.put(2,0);

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(m.get(1)>0) {
                    nums[m.get(0) + m.get(1)] = 1;
                }
                if(m.get(2)>0) {
                    nums[i] = 2;
                }
                nums[m.get(0)]=0;

                int tmp =m.get(0)+1;
                m.put(0,tmp);

            }
            else if(nums[i]==1){

                if(m.get(2)>0) {
                    nums[i] = 2;
                }
                nums[m.get(0)+m.get(1)]=1;
                int tmp = m.get(1)+1;
                m.put(1,tmp);
            }
            else{
                nums[i]=2;
                int tmp = m.get(2)+1;
                m.put(2,tmp);
            }

        }


    }

    public static void main(String[] args){
        SortColors s = new SortColors();
        int[] a =new int[]{2,0,2,1,1,0};
        s.sortColors(a);

    }
}
