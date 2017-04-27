package com.leetcode;

/**
 * Created by xiaoyuan on 26/04/2017.
 */
public class P309_BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {return 0;}

        int n = prices.length;
        int[][] dp = new int[n][3];
        // 0 buy
        // 1 sell
        // 2 nothing
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        int ans = 0;
        for (int i = 1; i< n; i++) {
            // buy
            dp[i][0] = dp[i - 1][2] - prices[i];

            // sell
            for (int j = i - 1; j >= 0; j--) {
                dp[i][1] = Math.max(dp[i][1], dp[j][0] + prices[i]);
            }

            // nothing
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i][2], dp[i - 1][2]);

            ans = Math.max(ans, dp[i][0]);
            ans = Math.max(ans, dp[i][1]);
            ans = Math.max(ans, dp[i][2]);
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
