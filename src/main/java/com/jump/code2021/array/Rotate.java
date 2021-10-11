package com.jump.code2021.array;

public class Rotate {

    public void rotate(int[][] matrix) {
//        先转置，再水平翻转
        transpose(matrix);
        horiReverse(matrix);
    }

    private void transpose(int[][] m){
        for(int i=0;i<m.length;i++){
            for(int j = i;j<m.length;j++){
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
        }
    }

    private void horiReverse(int[][] m){
        for(int i=0;i<m.length;i++){
            int left=0;
            int right=m[i].length-1;

            while (left<right){
                int tmp = m[i][left];
                m[i][left] = m[i][right];
                m[i][right] = tmp;
                left++;
                right--;
            }
        }
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

        Rotate r = new Rotate();
        r.rotate(a);

    }
}
