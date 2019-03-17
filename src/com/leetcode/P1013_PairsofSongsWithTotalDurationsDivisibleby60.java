package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P1013_PairsofSongsWithTotalDurationsDivisibleby60 {

    /**
     * easy
     * mod and count the number
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60(int[] time) {

        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int t : time) {
            t %= 60;
            cntMap.put(t, cntMap.getOrDefault(t, 0) + 1);
        }

        int ans = 0;
        for (int t : cntMap.keySet()) {
            if (t > 30) continue;

            int v = cntMap.get(t);
            if (t == 0 || t == 30) {
                ans += (v * (v - 1)) / 2;
            } else {
                int left = 60 - t;
                int now = cntMap.getOrDefault(left, 0);

                ans += v * now;
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new P1013_PairsofSongsWithTotalDurationsDivisibleby60().numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
        System.out.println(new P1013_PairsofSongsWithTotalDurationsDivisibleby60().numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }

}
