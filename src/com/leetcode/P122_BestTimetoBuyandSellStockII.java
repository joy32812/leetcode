package com.leetcode;

/**
 * Created by xiaoyuan on 14/03/2017.
 */
public class P122_BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {return 0;}

        int ans = 0;
        int begin = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                continue;
            } else {
                ans += (prices[i - 1] - prices[begin]);
                begin = i;
            }
        }

        ans += (prices[prices.length - 1] - prices[begin]);

        return ans;
    }

    public static void main(String[] args) {

    }

}
