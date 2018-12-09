package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P956_TallestBillboard {


    /**
     * medium
     * dp
     * update dp[diff] like knapsack
     * @param rods
     * @return
     */
    public int tallestBillboard(int[] rods) {

        Map<Integer, Integer> dpMap = new HashMap<>();
        dpMap.put(0, 0);

        for (int r : rods) {

            Map<Integer, Integer> curMap = new HashMap<>(dpMap);
            for (int k : dpMap.keySet()) {
                int b = dpMap.get(k);
                int a = b + k;

                int diff = Math.abs(b + r - a);
                int val = Math.min(b + r, a);
                val = Math.max(val, curMap.getOrDefault(diff, 0));
                curMap.put(diff, val);



                diff = Math.abs(a + r - b);
                val = Math.min(a + r, b);
                val = Math.max(val, curMap.getOrDefault(diff, 0));
                curMap.put(diff, val);
            }

            dpMap = curMap;
        }

        return dpMap.get(0);
    }


    public static void main(String[] args) {

        System.out.println(new P956_TallestBillboard().tallestBillboard(new int[]{1,2,4,8,16,32,64,128,256,512,50,50,50,150,150,150,100,100,100,123}));

    }


}
