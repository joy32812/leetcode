package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 26/06/2017.
 */
public class P532_KdiffPairsinanArray {

    public int findPairs(int[] nums, int k) {
        if (k < 0) {return 0;}

        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int d : nums) {
            cntMap.put(d, cntMap.getOrDefault(d, 0) + 1);
        }

        int ans = 0;
        if (k == 0) {
            for (int val : cntMap.values()) {
                if (val >= 2) {ans++;}
            }
        } else {
            for (int key : cntMap.keySet()) {
                if (cntMap.containsKey(key + k)) {
                    ans++;
                }
            }
        }

        return ans;
    }

}
