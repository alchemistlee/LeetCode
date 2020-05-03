package com.jump.leetcode.bfs;

import java.util.*;

public class CountIsland {



    public String[] getIndex(String s){
        String[] ts = s.split("-");
        return ts;
    }

    public String covKey(int row_idx, int col_idx){
        String key = row_idx+"-"+col_idx;
        return key;
    }

    public int numIslands(char[][] grid) {

        Queue<Queue<String>> d = new LinkedList<Queue<String>>();

        Set<String> exp = new HashSet<String>();
        Set<String> unsee = new HashSet<String>();



        // System.out.println(cs+"-"+rs);

        if(grid.length > 0 && grid[0].length > 0) {
            Queue<String> tq = new LinkedList<String>();
            tq.offer("0-0");
            d.offer(tq);
        }
        else{
            return 0;
        }

        int cs  = grid.length;
        int rs =  grid[0].length;

        int cur_loop_size = 0;
        int is_num = 0;

        while(d.size()>0){

            Queue<String> curq = d.poll();
            cur_loop_size = curq.size();

            if(exp.contains(curq.peek())){
                continue;
            }

            String target = "-1";
            while(curq.size()>0){

                int tmp_size = 0;

                for(int i=0;i<cur_loop_size;i++){
                    String item = curq.poll();
                    if(!exp.contains(item)){
                        exp.add(item);
                    }

                    String[] idxs = getIndex(item);
                    int c_idx = Integer.parseInt(idxs[0]);
                    int r_idx = Integer.parseInt(idxs[1]);

                    if(target.equals("-1")){
                        target = String.valueOf(grid[c_idx][r_idx]);
                    }
                    // System.out.println(c_idx+"--"+);
                    List<String> tmpkey = new ArrayList<String>();
                    if(c_idx+1 < cs ){
                        tmpkey.add(covKey(c_idx+1,r_idx)+"#"+grid[c_idx+1][r_idx]);
                    }
                    if(r_idx+1 < rs ){
                        tmpkey.add(covKey( c_idx,r_idx+1)+"#"+grid[c_idx][r_idx+1]);
                    }
                    if(c_idx-1 >= 0 ){
                        tmpkey.add(covKey(c_idx-1,r_idx)+"#"+grid[c_idx-1][r_idx]);

                    }
                    if(r_idx-1 >=0){
                        tmpkey.add(covKey(c_idx,r_idx-1)+"#"+grid[c_idx][r_idx-1]);
                    }


                    for(String tk : tmpkey){

                        String[] cp = tk.split("#");
                        String idxk = cp[0];
                        String val = cp[1];

                        if(exp.contains(idxk)){
                            continue;
                        }
                        // System.out.println(val);

                        if(val.equals(target)){
                            curq.offer(idxk);
                            exp.add(idxk);
                            tmp_size +=1;
                        }
                        else{
                            Queue<String> ttq = new LinkedList<String>();
                            ttq.offer(idxk);
                            d.offer(ttq);
                        }
                    }

                }
                System.out.println(tmp_size);

                cur_loop_size = tmp_size;

            }

            if(target.equals("1")){
                is_num+=1;
            }

        }

        return is_num;

    }

    public static void main(String[] args){

    }
}
