package com.jump.code2021.array;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        minPathVal = Integer.MAX_VALUE;
        backtrack(grid,new int[]{0,0},grid[0][0]);
        return minPathVal;
    }

    private int minPathVal ;

    private void backtrack(int[][] g, int[] selected, int pathSum){
        int rowSize = g.length;
        int colSize = g[0].length;

        if(selected[0] == rowSize-1 && selected[1] == colSize-1){
            if(pathSum<minPathVal){
                minPathVal = pathSum;
            }
            return;
        }

        int[] tmpSelected = new int[2];

        if(selected[0]<rowSize-1){
            tmpSelected[0] = selected[0]+1;
            tmpSelected[1] = selected[1];
            int tmpSum = pathSum+g[tmpSelected[0]][tmpSelected[1]];
            backtrack(g, tmpSelected, tmpSum);

        }

        if(selected[1]<colSize-1){
            tmpSelected[0] = selected[0];
            tmpSelected[1] = selected[1]+1;

            int tmpSum = pathSum+g[tmpSelected[0]][tmpSelected[1]];
            backtrack(g, tmpSelected, tmpSum);
        }

    }


    public static void main(String[] args){
        MinPathSum m = new MinPathSum();

        int[][] a = new int[3][3];
        a[0][0]=1;
        a[0][1]=3;
        a[0][2]=1;
        a[1][0]=1;
        a[1][1]=5;
        a[1][2]=1;
        a[2][0]=4;
        a[2][1]=2;
        a[2][2]=1;

        int r = m.minPathSum(a);
        System.out.println(r);
    }
}
