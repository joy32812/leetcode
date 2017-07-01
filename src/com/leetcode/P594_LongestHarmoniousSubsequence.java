package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P594_LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {

        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int d : nums) {
            cntMap.put(d, cntMap.getOrDefault(d, 0) + 1);
        }

        int ans = 0;
        for (int key : cntMap.keySet()) {
            ans = Math.max(ans , cntMap.get(key) + (cntMap.containsKey(key + 1) ? cntMap.get(key + 1) : -1 * cntMap.get(key)));
        }

        return ans;
    }

}
