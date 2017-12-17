package com.leetcode;

import java.util.Arrays;

public class A1 {



    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 0; i < n; i++) {
            if (i + 1 <= n) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + cost[i]);
            }

            if (i + 2 <= n) {
                dp[i + 2] = Math.min(dp[i + 2], dp[i] + cost[i]);
            }

        }

        return dp[n];
    }



    public static void main(String[] args) {

    }

}
