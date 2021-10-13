package com.jump.code2021.array;

import java.util.HashSet;
import java.util.Set;

public class ExistWord {

    public boolean exist(char[][] board, String word) {
        isExistTarget = false;
        for(int i=0;i<board.length;i++){

            for(int j=0;j<board[0].length;j++){
                Set<String> tmp = new HashSet<>();
                tmp.add(i+""+j);
                backtrack(board,i,j,word,board[i][j]+"",tmp);

                if(isExistTarget){
                    break;
                }

            }
        }

        return  isExistTarget;
    }

    private boolean isExistTarget=false;

    private void backtrack(char[][] board, int  si, int sj, String tar, String path, Set<String> visited){
        if(path.equals(tar)){
            isExistTarget = true;
            return;
        }

        if(path.length()>= tar.length()){
            return;
        }

        Set<String> tmpVist=new HashSet<>();
        tmpVist.addAll(visited);

        if(si<board.length-1){
            String k = (si+1)+""+sj;
            if(!tmpVist.contains(k)) {
                String t = path + board[si + 1][sj];
                tmpVist.add(k);
                backtrack(board, si + 1, sj, tar, t,tmpVist);
                tmpVist.clear();
                tmpVist.addAll(visited);
            }
        }

        if(si>0){
            String k = (si-1)+""+sj;
            if(!tmpVist.contains(k)) {
                String t = path + board[si - 1][sj];

                tmpVist.add(k);
                backtrack(board,si-1,sj, tar,t,tmpVist);
                tmpVist.clear();
                tmpVist.addAll(visited);
            }

        }

        if(sj<board[0].length-1){
            String k = si+""+(sj+1);
            if(!tmpVist.contains(k)) {
                String t = path + board[si][sj+1];
                tmpVist.add(k);
                backtrack(board, si, sj+1, tar, t,tmpVist);
                tmpVist.clear();
                tmpVist.addAll(visited);
            }
        }

        if(sj>0){
            String k = si+""+(sj-1);
            if(!tmpVist.contains(k)) {
                String t = path + board[si][sj-1];

                tmpVist.add(k);
                backtrack(board,si,sj-1, tar,t,tmpVist);
                tmpVist.clear();
                tmpVist.addAll(visited);
            }

        }
    }

    public static void main(String[] args){
        char[][] a= new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String w = "ABCB";

        ExistWord e = new ExistWord();
        boolean res = e.exist(a,w);
        System.out.println(res);
    }
}
