package com.leetcode;

import java.util.List;

/**
 * Created by xiaoyuan on 15/05/2017.
 */
public class P364_NestedListWeightSumII {

    public int depthSumInverse(List<NestedInteger> nestedList) {

        int maxDepth = work(nestedList);
        return compute(nestedList, maxDepth);
    }

    private int compute(List<NestedInteger> nestedList, int maxDepth) {
        int ans = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                ans += maxDepth * ni.getInteger();
            } else {
                ans += compute(ni.getList(), maxDepth - 1);
            }
        }

        return ans;
    }

    private int work(List<NestedInteger> nestedList) {
        int maxDepth = 1;
        for (NestedInteger ni : nestedList) {
            if (!ni.isInteger()) {
                maxDepth = Math.max(maxDepth, work(ni.getList()) + 1);
            }
        }
        return maxDepth;
    }

}
