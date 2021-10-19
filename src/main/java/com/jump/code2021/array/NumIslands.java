package com.jump.code2021.array;

import java.util.*;

public class NumIslands {


    public int numIslands(char[][] grid) {
        int islandCnt = 0;
        for(int i=0;i<grid.length;i++){

            Map<Integer,Integer> idx2island = new HashMap<>();
            Set<Integer> allIsland = new HashSet<>();
            Set<Integer> dupIslands = new HashSet<>();

            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    if(i==0 || grid[i-1][j]=='0'){
                        //纵向无连接
                        if(j==0 || grid[i][j-1]=='0'){
                            idx2island.put(j,j);
                            allIsland.add(j);
                        }
                        else {
                            idx2island.put(j,idx2island.get(j-1));
                        }
                    }
                    else{

                        //纵向有连接
                        if(j==0 || grid[i][j-1]=='0'){
                            idx2island.put(j,j);
                            allIsland.add(j);
                        }
                        else {
                            idx2island.put(j,idx2island.get(j-1));
                        }
                        dupIslands.add(idx2island.get(j));

                    }
                }


            }

            islandCnt+=(allIsland.size()-dupIslands.size());

        }
        return islandCnt;

    }

    public static void main(String[] args){
        char[][] g = new char[][]{{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};

        char[][] g1 = new char[][]{{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        NumIslands n = new NumIslands();
        int r = n.numIslands(g1);
        System.out.println(r);
    }
}
