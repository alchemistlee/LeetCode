package com.jump.code2021.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int level = 0;
        int rowLen = n ;
        int colLen= m;

        List<Integer> res = new ArrayList<>();

        int i=0;
        int j=0;

        int direction = 0;

        while (rowLen>1 || colLen>1){

            if(direction==0){

                for(int c=0;c<rowLen-1;c++){

                    int tmp = matrix[i][j];
                    res.add(tmp);
                    j=j+1;
                }

//                if(rowLen>1){
//                    j=j+1;
//                }

            }
            else if(direction==1){
                for(int c=0;c<colLen-1;c++){
                    int tmp = matrix[i][j];
                    res.add(tmp);
                    i=i+1;
                }
//                if(colLen>1){
//                    i=i+1;
//                }
            }
            else if(direction==2){
                for(int c=0;c<rowLen-1;c++){
                    int tmp = matrix[i][j];
                    res.add(tmp);
                    j = j-1;

                }
//                if(rowLen>1){
//                    j= j-1;
//                }
            }
            else{
                for(int c=0;c<colLen-1;c++){
                    int tmp = matrix[i][j];
                    res.add(tmp);
                    i=i-1;
                }

                j=j+1;
                i=i+1;

                level+=1;
                rowLen =  rowLen-2;
                colLen = colLen-2;


            }

            direction = (direction+1)%4;

        }

        if(rowLen==1 && colLen==1){
            res.add(matrix[i][j]);
        }

        return res;
    }


    public static void main(String[] args){
        int[][] a = new int[3][3];
        a[0][0]=1;
        a[0][1]=2;
        a[0][2]=3;
        a[1][0]=4;
        a[1][1]=5;
        a[1][2]=6;
        a[2][0]=7;
        a[2][1]=8;
        a[2][2]=9;

        int[][] b = new int[3][4];
        b[0][0]=1;
        b[0][1]=2;
        b[0][2]=3;
        b[0][3]=4;
        b[1][0]=5;
        b[1][1]=6;
        b[1][2]=7;
        b[1][3]=8;
        b[2][0]=9;
        b[2][1]=10;
        b[2][2]=11;
        b[2][3]=12;


        SpiralOrder s = new SpiralOrder();
        List<Integer> r= s.spiralOrder(b);
    }
}