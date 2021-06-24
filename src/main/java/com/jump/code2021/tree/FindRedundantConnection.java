package com.jump.code2021.tree;

public class FindRedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int nodeCnt = edges.length;

        int[] parent = new int[nodeCnt];

        for(int i=0;i<nodeCnt;i++){
            parent[i]= i;
        }


        for(int j=0;j<edges.length;j++){
            int[] curEdge = edges[j];

            int node1 = curEdge[0];
            int node2 = curEdge[1];

            int par1 = find(parent,node1-1);
            int par2 = find(parent,node2-1);

            if(par1!=par2){
                union(parent,node1-1,node2-1);
            }
            else{
                return curEdge;
            }

        }

        return new int[]{};

    }

    private void union(int[] parent, int idx1, int idx2){
        parent[find(parent,idx1)]= find(parent,idx2);
    }



    private int find(int[] parent, int idx){
        if(parent[idx]!=idx){
            return find(parent, parent[idx]);
        }
        return parent[idx];
    }

    public static void main(String[] args){

        int[][] a = {{1,2}, {1,3}, {2,3}};

        FindRedundantConnection f = new FindRedundantConnection();
        int[] res = f.findRedundantConnection(a);
        System.out.println(res.toString());
    }
}
