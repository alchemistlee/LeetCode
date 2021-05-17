package com.jump.code2021.tree;

import java.util.Iterator;
import java.util.List;

public class FlattenNestedInteger {

    class NestedInteger {
        // 如果其中存的是一个整数，则返回 true，否则返回 false
        public boolean isInteger(){
            return true;
        }

        // 如果其中存的是一个整数，则返回这个整数，否则返回 null
        public Integer getInteger(){
            return null;
        }

        // 如果其中存的是一个列表，则返回这个列表，否则返回 null
        public List<NestedInteger> getList(){
            return null;
        }
    }

    public class NestedIterator implements Iterator<Integer> {

        public NestedIterator(List<NestedInteger> nestedList) {

        }

        @Override
        public Integer next() {
            return null;
        }

        @Override
        public boolean hasNext() {
            return false;
        }
    }


    public static void main(String[] args){



    }



}
