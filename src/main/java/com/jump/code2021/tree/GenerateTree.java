package com.jump.code2021.tree;

public class GenerateTree {

    public int numTrees(int n) {
        return geneIt(1,n);
    }


    public  int geneIt(int start, int end){
        if(start>end){
            return 1;
        }
        int res=0;
        for(int i=start;i<=end;i++){
            int l = geneIt(start,i-1);
            int r = geneIt(i+1,end);
            res+=l*r;
        }
        return res;
    }

    public static void main(String[] args){
        GenerateTree g = new GenerateTree();
        System.out.println(g.numTrees(1));
    }
}
