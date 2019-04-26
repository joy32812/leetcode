package com.leetcode;

/**
 * Created by xiaoyuan on 14/03/2017.
 */
public class P123_BestTimetoBuyandSellStockIII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;

        int[][] dp = new int[3][n];
        for (int i = 1; i <= 2; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
            }
        }

        return Math.max(0, Math.max(dp[1][n - 1], dp[2][n - 1]));
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;

        int ans = 0;
        int[] sellMax = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, prices[i]);
            sellMax[i] = Math.max(sellMax[i], prices[i] - min);
        }



        int[] buyMax = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            buyMax[i] = Math.max(buyMax[i], max - prices[i]);
        }


        int[] rightBuyMax = new int[n + 1];
        max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, buyMax[i]);
            rightBuyMax[i] = max;
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, sellMax[i] + rightBuyMax[i + 1]);
        }


        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new P123_BestTimetoBuyandSellStockIII().maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
    }

}
