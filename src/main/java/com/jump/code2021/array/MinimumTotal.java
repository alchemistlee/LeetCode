package com.jump.code2021.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        minSum = Integer.MAX_VALUE;
        backtrack(triangle,0,0,triangle.get(0).get(0));
        return minSum;
    }

    private int minSum=Integer.MAX_VALUE;

    private void backtrack(List<List<Integer>> board, int row, int col, int pathSum){
        if(row+1 == board.size()){
            if(minSum>pathSum){
                minSum = pathSum;
            }
            return;
        }

        int tmpPath = pathSum;
        tmpPath+=board.get(row+1).get(col);
        backtrack(board,row+1,col,tmpPath);

        tmpPath = pathSum + board.get(row+1).get(col+1);
        backtrack(board,row+1,col+1,tmpPath);

    }

    public static void main(String[] args){
        List<List<Integer>> tri = new ArrayList<>();
        tri.add(Arrays.asList(new Integer[]{2}));
        tri.add(Arrays.asList(new Integer[]{3,4}));
        tri.add(Arrays.asList(new Integer[]{6,5,7}));
        tri.add(Arrays.asList(new Integer[]{4,1,8,3}));

        MinimumTotal m = new MinimumTotal();
        int r = m.minimumTotal(tri);

        System.out.println(r);
    }
}
