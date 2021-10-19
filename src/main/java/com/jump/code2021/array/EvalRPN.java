package com.jump.code2021.array;

import java.util.ArrayList;
import java.util.List;

public class EvalRPN {

    public int evalRPN(String[] tokens) {
        if(tokens.length==1){
            return Integer.valueOf(tokens[0]);
        }


        List<String> tmp =new ArrayList<>();

        boolean isDealt = false;
        for(int i=0;i<tokens.length;i++){
            if(!isDealt) {
                if (tokens[i].equals("+")) {
                    int tt = Integer.valueOf(tokens[i - 2]) + Integer.valueOf(tokens[i - 1]);
                    tmp.remove(tmp.size() - 1);
                    tmp.remove(tmp.size() - 1);
                    tmp.add(tt + "");

                    isDealt = true;
                    continue;

                } else if (tokens[i].equals("-")) {
                    int tt = Integer.valueOf(tokens[i - 2]) - Integer.valueOf(tokens[i - 1]);
                    tmp.remove(tmp.size() - 1);
                    tmp.remove(tmp.size() - 1);
                    tmp.add(tt + "");

                    isDealt = true;
                    continue;

                } else if (tokens[i].equals("*")) {
                    int tt = Integer.valueOf(tokens[i - 2]) * Integer.valueOf(tokens[i - 1]);
                    tmp.remove(tmp.size() - 1);
                    tmp.remove(tmp.size() - 1);
                    tmp.add(tt + "");

                    isDealt = true;
                    continue;
                } else if (tokens[i].equals("/")) {
                    int tt = Integer.valueOf(tokens[i - 2]) / Integer.valueOf(tokens[i - 1]);
                    tmp.remove(tmp.size() - 1);
                    tmp.remove(tmp.size() - 1);
                    tmp.add(tt + "");

                    isDealt = true;
                    continue;
                }
            }

            tmp.add(tokens[i]);

        }
        String[] t2 =tmp.toArray(new String[0]);
        return evalRPN(t2);

    }

    public static void main(String[] args){
        EvalRPN e = new EvalRPN();
        String[] a = new String[]{"4","13","5","/","+"};
        int res = e.evalRPN(a);


    }
}
