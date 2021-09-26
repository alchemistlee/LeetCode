package com.jump.code2021.array;

import java.util.*;

public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<String>> rowStat = new HashMap<>();
        Map<Integer,Set<String>> colStat = new HashMap<>();
        Map<Integer,Set<String>> subStat = new HashMap<>();

        for(int i=0;i<board.length;i++){

            for(int j=0;j<board[i].length;j++){

                if(board[i][j]=='.'){
                    continue;
                }

                if(!rowStat.containsKey(i)){
                    rowStat.put(i,new HashSet<>());
                }

                Set<String> tmpSet = rowStat.get(i);
                if(tmpSet.contains(board[i][j]+"")){
                    return false;
                }
                else{
                    tmpSet.add( board[i][j]+"" );
                }

                if(!colStat.containsKey(j)){
                    colStat.put(j,new HashSet<>());
                }

                tmpSet = colStat.get(j);
                if(tmpSet.contains(board[i][j]+"")){
                    return false;
                }
                else{
                    tmpSet.add(board[i][j]+"");
                }

                int subIdx = transSubIdx(i,j,3,3);
                if(!subStat.containsKey(subIdx)){
                    subStat.put(subIdx,new HashSet<>());
                }
                tmpSet = subStat.get(subIdx);

                if(tmpSet.contains( board[i][j]+"")){
                    return false;
                }
                else{
                    tmpSet.add(board[i][j]+"");
                }
            }
        }

        return true;

    }


    private int transSubIdx(int i, int j, int rowSubCnt, int colSubCnt){
        int rowSubIdx = (i)/rowSubCnt;
        int colSubIdx = (j)/colSubCnt;

        return rowSubIdx*rowSubCnt+colSubIdx;
    }

    public static void main(String[] args){
        IsValidSudoku a = new IsValidSudoku();
        char[][] b = new char[][]{{'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(a.isValidSudoku(b));
    }
}
