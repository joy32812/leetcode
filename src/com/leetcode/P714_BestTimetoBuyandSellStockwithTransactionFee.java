package com.leetcode;

/**
 * Created by xiaoyuan on 23/10/2017.
 */
public class P714_BestTimetoBuyandSellStockwithTransactionFee {

    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;

        int s0 = 0; // nothing in hand
        int s1 = Integer.MIN_VALUE; // have one

        for (int i = 0; i < n; i++) {
            int tmp = s0;

            s0 = Math.max(s0, s1 + prices[i]);
            s1 = Math.max(s1, tmp - prices[i] - fee);
        }

        return Math.max(s0, s1);
    }

    public static void main(String[] args) {
        System.out.println(new P714_BestTimetoBuyandSellStockwithTransactionFee().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }

}
