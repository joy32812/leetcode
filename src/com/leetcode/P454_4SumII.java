package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 08/06/2017.
 */
public class P454_4SumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0) {return 0;}

        int n = A.length;

        Map<Integer, Integer> aMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = A[i] + B[j];
                aMap.put(key, aMap.getOrDefault(key, 0) + 1);
            }
        }

        Map<Integer, Integer> bMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = C[i] + D[j];
                bMap.put(key, bMap.getOrDefault(key, 0) + 1);
            }
        }

        int ans = 0;

        for (int d : aMap.keySet()) {
            if (!bMap.containsKey(-d)) {continue;}
            ans += aMap.get(d) * bMap.get(-d);
        }

        return ans;
    }


}
