package com.leetcode;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by xiaoyuan on 06/12/2017.
 */
public class P740_DeleteandEarn {

    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }

        int size = treeMap.size();

        int[] v = new int[size];
        int[] c = new int[size];

        int cnt = 0;
        for (int key : treeMap.keySet()) {
            v[cnt] = key;
            c[cnt] = treeMap.get(key);
            cnt++;
        }


        int dp[][] = new int[size][2];
        dp[0][0] = 0;
        dp[0][1] = c[0] * v[0];

        for (int i = 1; i < size; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            if (v[i] == v[i - 1] + 1) {
                dp[i][1] = dp[i - 1][0] + c[i] * v[i];
            } else {
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + c[i] * v[i];
            }
        }

        return Math.max(dp[size - 1][0], dp[size - 1][1]);

    }

}
