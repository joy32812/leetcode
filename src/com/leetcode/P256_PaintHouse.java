package com.leetcode;

/**
 * Created by xiaoyuan on 14/04/2017.
 */
public class P256_PaintHouse {

    public int minCost(int[][] costs) {
        if (costs.length == 0) {return 0;}

        int[] dp = new int[]{costs[0][0], costs[0][1], costs[0][2]};
        for (int i = 1; i < costs.length; i++) {
            int a = costs[i][0] + Math.min(dp[1], dp[2]);
            int b = costs[i][1] + Math.min(dp[0], dp[2]);
            int c = costs[i][2] + Math.min(dp[0], dp[1]);

            dp[0] = a;
            dp[1] = b;
            dp[2] = c;
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

}
