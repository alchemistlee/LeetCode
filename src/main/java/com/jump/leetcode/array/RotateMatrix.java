package com.jump.leetcode.array;

/**
 * @author : alchemistlee on 2019/8/14
 * @version : 0.0.1
 **/

public class RotateMatrix {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int tmp= matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]= tmp;
            }
        }

        //print
        for(int i=0;i<n;i++){
            StringBuffer sw =new StringBuffer();
            for(int j=0;j<n;j++){
                sw.append(","+String.valueOf(matrix[i][j]));
            }
            System.out.println(sw.toString());
        }

    }

    public static void main(String[] args){
        int[][] a ={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(a);
    }

}