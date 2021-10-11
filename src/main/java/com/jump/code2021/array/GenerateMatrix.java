package com.jump.code2021.array;

import java.util.HashMap;
import java.util.Map;

public class GenerateMatrix {

    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];
        int si = 0;
        int sj = 0;

        Map<String,Integer> isVisit = new HashMap<>();

        int i=si;
        int j=sj;

        int upRow=0;
        int botRow =n-1;
        int rightCol=n-1;
        int leftCol = 0;

        int tmpn = 1;

        while (!isVisit.containsKey(i+""+j)){

            if(i==upRow && j==leftCol){
                res[i][j] = tmpn;
                isVisit.put(i+""+j,1);
                j++;
                tmpn++;
            }
            else if(i==upRow && j==rightCol){
                res[i][j] = tmpn;
                isVisit.put(i+""+j,1);
                i++;
                tmpn++;
            }
            else if(j==rightCol && i==botRow){
                res[i][j] = tmpn;
                isVisit.put(i+""+j,1);
                j--;
                tmpn++;
            }
            else if(j==leftCol && i==botRow){
                res[i][j]=tmpn;
                isVisit.put(i+""+j,1);
                i--;
                tmpn++;
            }
            else if(i==upRow){
                res[i][j] = tmpn;
                isVisit.put(i+""+j,1);
                j++;
                tmpn++;
            }
            else if(j==rightCol){
                res[i][j] = tmpn;
                isVisit.put(i+""+j,1);
                i++;
                tmpn++;
            }
            else if(i==botRow){
                res[i][j] = tmpn;
                isVisit.put(i+""+j,1);
                j--;
                tmpn++;
            }
            else{
                res[i][j] = tmpn;
                isVisit.put(i+""+j,1);
                int tmpi = i-1;
                if(tmpi==si && j==sj){
                    si=i;
                    sj=j+1;

                    upRow = upRow+1;
                    leftCol = leftCol+1;
                    botRow = botRow-1;
                    rightCol = rightCol-1;

                    i=si;
                    j=sj;

                }
                else{
                    i = tmpi;
                }
                tmpn++;
            }

        }

        return res;

    }

    public static void main(String[] args){
        int n=3;
        GenerateMatrix g = new GenerateMatrix();
        int[][] m = g.generateMatrix(n);

    }
}
