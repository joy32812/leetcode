package com.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xiaoyuan on 11/05/2017.
 */
public class P341_FlattenNestedListIterator {


    public static void main(String[] args) {
        List<NestedInteger> list = new ArrayList<>();
        list.add(new NestedInteger() {
            @Override
            public boolean isInteger() {
                return true;
            }

            @Override
            public Integer getInteger() {
                return 1;
            }

            @Override
            public List<NestedInteger> getList() {
                return null;
            }
        });
    }
}

class NestedIterator implements Iterator<Integer> {

    private List<Integer> ans;
    private int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        ans = new ArrayList<>();
        index = 0;

        for (NestedInteger nestedInteger : nestedList) {
            dfs(nestedInteger);
        }
    }

    private void dfs(NestedInteger nestedInteger) {
        if (nestedInteger == null) {return;}

        if (nestedInteger.isInteger()) {
            ans.add(nestedInteger.getInteger());
            return;
        }

        for (NestedInteger nInteger : nestedInteger.getList()) {
            dfs(nInteger);
        }
    }

    @Override
    public Integer next() {
        return ans.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < ans.size();
    }
}