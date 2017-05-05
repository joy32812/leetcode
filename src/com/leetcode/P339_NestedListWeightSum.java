package com.leetcode;

import java.util.List;

/**
 * Created by xiaoyuan on 05/05/2017.
 */

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class P339_NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        return work(nestedList, 1);
    }

    private int work(List<NestedInteger> nestedList, int d) {
        int ans = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger ni = nestedList.get(i);
            if (ni.isInteger()) {
                ans += d * ni.getInteger();
            } else {
                ans += work(ni.getList(), d + 1);
            }
        }

        return ans;
    }

}
