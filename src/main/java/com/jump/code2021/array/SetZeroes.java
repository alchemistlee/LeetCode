package com.jump.code2021.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        Set<Integer> tarRows = new HashSet<>();
        Set<Integer> tarCols = new HashSet<>();

        for(int i=0;i<matrix.length;i++){

            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    tarRows.add(i);
                    tarCols.add(j);
                }
            }
        }

        for(Integer i : tarRows){
            for(int j =0;j<matrix[0].length;j++){
                matrix[i][j]=0;
            }
        }

        for(Integer j : tarCols){
            for(int i=0;i<matrix.length;i++){
                matrix[i][j]=0;
            }
        }

    }

    public static void main(String[] args){
        int[][] a= new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        SetZeroes s = new SetZeroes();
        s.setZeroes(a);
    }
}
