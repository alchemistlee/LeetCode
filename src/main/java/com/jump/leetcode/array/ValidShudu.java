package com.jump.leetcode.array;

import java.util.HashSet;

/**
 * @author : alchemistlee on 2019/8/13
 * @version : 0.0.1
 **/

public class ValidShudu {


    public static boolean isValidSudoku(char[][] board) {

        for(int i=0;i<9;i++){
            HashSet<Character> col= new HashSet<>();
            HashSet<Character> row =new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j]!='.' && !row.add(board[i][j])){
                    return false;
                }
                if(board[j][i]!='.' && !col.add(board[j][i])){
                    return false;
                }
                int cub_col=(i%3)*3+j%3;
                int cub_row=(i/3)*3+j/3;
                if(board[cub_row][cub_col]!='.' && !cube.add(board[cub_row][cub_col])){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args){
        char[][] a={{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(a));

    }
}
