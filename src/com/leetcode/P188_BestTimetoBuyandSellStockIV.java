package com.leetcode;

/**
 * Created by xiaoyuan on 29/03/2017.
 */
public class P188_BestTimetoBuyandSellStockIV {

    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) {return 0;}
        int n = prices.length;

        if (k >= n / 2) {return quickSolve(prices);}

        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], tmpMax + prices[j]);
                tmpMax = Math.max(dp[i - 1][j - 1] - prices[j], tmpMax);
            }
        }

        return dp[k][n - 1];
    }

    private int quickSolve(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length;i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }

        return ans;
    }


}
