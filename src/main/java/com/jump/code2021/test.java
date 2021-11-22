//package com.jump.code2021;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class test {
//
//    private static class Node{
//          int idx;
//          List<Node> nextNode;
//
//          Node(int idx, List<Node> nextNode){
//            this.idx = idx;
//            this.nextNode = nextNode;
//          }
//
//    }
//
//    private List<Node> trans2Graphs(List<List<Integer>> order){
//        Map<Integer, Node> allNodes = new HashMap<>();
//
//        for(int i=0;i<order.size();i++){
//            List<Integer> curConnect = order.get(i);
//
//            int pre = curConnect.get(0);
//            int aft = curConnect.get(1);
//
//            if(!allNodes.containsKey(pre)){
//                Node tmo = new Node(pre);
//            }
//        }
//    }
//
//    private int bfsIt(Node root){
//
//    }
//
//    public int getCostTime(List<List<Integer>> order, List<Integer> timeCost){
//        List<Node> graphs = trans2Graphs(order);
//
//        int res = 0 ;
//        for(int i=0;i<graphs.size();i++){
//            int curCost = bfsIt(graphs.get(i));
//            if(curCost>res){
//                res = curCost;
//            }
//        }
//        return res;
//    }
//
//
//    public static void main(String[] args){
//
//    }
//}
