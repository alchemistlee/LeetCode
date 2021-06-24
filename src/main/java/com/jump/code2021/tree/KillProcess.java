package com.jump.code2021.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> tar = new ArrayList<>();
        tar.add(kill);
        killAll(pid,ppid,tar);
        return res;
    }

    private List<Integer> res=new ArrayList<>();

    private void killAll(List<Integer> pid, List<Integer> ppid, List<Integer> killTarget){
        if(killTarget.isEmpty()){
            return;
        }
        res.addAll(killTarget);

        List<Integer> tmp = new ArrayList<>();
        for(int i=0;i<ppid.size();i++){
            int parId = ppid.get(i);
            int chiId=  pid.get(i);
            if(killTarget.contains(parId)){
                tmp.add(chiId);
            }
        }

        killAll(pid,ppid,tmp);

    }

    public static void main(String[] args){
//        int[] pid = new int[]{1,3,10,5};
//        int[] ppid = new int[]{3,0,5,3};
        List<Integer> pid2 = new ArrayList<>();
        pid2.add(1);
        pid2.add(3);
        pid2.add(10);
        pid2.add(5);

        List<Integer> ppid2 = new ArrayList<>();
        ppid2.add(3);
        ppid2.add(0);
        ppid2.add(5);
        ppid2.add(3);
        KillProcess k = new KillProcess();
        System.out.println(k.killProcess(pid2,ppid2,5));
    }
}
