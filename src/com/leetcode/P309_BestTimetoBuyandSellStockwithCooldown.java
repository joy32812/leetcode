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
        // 2 cool down
        dp[0][0] = -prices[0];
        dp[0][1] = Integer.MIN_VALUE / 2;
        dp[0][2] = 0;

        int ans = 0;
        int tmpMax = -prices[0];
        for (int i = 1; i< n; i++) {
            // buy
            dp[i][0] = dp[i - 1][2] - prices[i];


            // sell
            dp[i][1] = tmpMax + prices[i];
            tmpMax = Math.max(tmpMax, dp[i][0]);

            // cool down
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i][2], dp[i - 1][2]);


            for (int k = 0; k < 3; k++) ans = Math.max(ans, dp[i][k]);
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(new P309_BestTimetoBuyandSellStockwithCooldown().maxProfit(new int[]{1, 2, 3, 0, 2}));

    }

}
