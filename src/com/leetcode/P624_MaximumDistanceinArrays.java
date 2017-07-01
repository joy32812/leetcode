package com.leetcode;

import java.util.List;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P624_MaximumDistanceinArrays {

    public int maxDistance(List<List<Integer>> arrays) {

        List<Integer> firstList = arrays.get(0);
        int min = firstList.get(0);
        int max = firstList.get(firstList.size() - 1);

        int ans = 0;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> nowList = arrays.get(i);

            ans = Math.max(ans, Math.abs(nowList.get(0) - min));
            ans = Math.max(ans, Math.abs(nowList.get(nowList.size() - 1) - min));
            ans = Math.max(ans, Math.abs(nowList.get(0) - max));
            ans = Math.max(ans, Math.abs(nowList.get(nowList.size() - 1) - max));

            min = Math.min(min, nowList.get(0));
            max = Math.max(max, nowList.get(nowList.size() - 1));
        }

        return ans;
    }

}
