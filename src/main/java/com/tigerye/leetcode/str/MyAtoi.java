package com.tigerye.leetcode.str;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : alchemistlee on 2019/8/14
 * @version : 0.0.1
 **/

public class MyAtoi {

    public static int myAtoi(String str){
        int posOrNeg = 1;
        List<Integer> buff = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            char tmp = str.charAt(i);
            if(tmp==' '){
                continue;
            }
            else if(tmp=='-'){
                posOrNeg = -1;
            }
            else if(Character.isDigit(tmp)){
                buff.add(Integer.valueOf(String.valueOf(tmp)));
            }
            else{
                break;
            }
        }

        int res = 0;

        for(int i=buff.size()-1,j=0;i>=0;i--,j++){
            Integer tmp = buff.get(i);
            Double dTmp = tmp*Math.pow(10,j);
            res+=dTmp;
        }
        res*=posOrNeg;

        if(res>Math.pow(2,31)-1){
            return (int)Math.pow(2,31)-1;
        }
        else if(res<Math.pow(2,31)*-1){
            return (int)Math.pow(2,31)*-1;
        }

        return res;

    }

    public static void main(String[] args) {

        String a ="-912834723327";
        System.out.println(myAtoi(a));
    }
}
