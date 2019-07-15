package com.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class P1124_LongestWellPerformingInterval {


    public int longestWPI(int[] hours) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        int sum = 0;
        treeMap.put(sum, -1);

        int ans = 0;

        int min = 0;
        for (int i = 0; i < hours.length; i++) {
            int d = hours[i];

            sum += (d > 8 ? 1 : -1);


            Map.Entry<Integer, Integer> entry = treeMap.floorEntry(sum - 1);
            if (entry != null) ans = Math.max(ans, i - entry.getValue());

            if (sum < min) {
                min = sum;
                treeMap.put(sum, i);
            }
        }

        return ans;
    }


}
