package com.jump.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : alchemistlee on 2019/8/13
 * @version : 0.0.1
 **/

public class getIntersect {

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<nums1.length;i++){

            if(!res.contains(nums1[i])) {

                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        res.add(nums1[i]);
                        break;
                    }

                }
            }
        }

        int[] resArr = new int[res.size()];
        for(int i=0;i<res.size();i++){
            resArr[i]=res.get(i).intValue();
        }
        return resArr;
    }

    public static void main(String[] args){
        int[] a={1,2,2,3,1};
        int[] b={2,2,3};
        int[] c = intersect(a,b);
        for(int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
    }
}
