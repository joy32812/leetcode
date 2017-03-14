package com.leetcode;

/**
 * Created by xiaoyuan on 14/03/2017.
 */
public class P121_BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {return 0;}

        int ans = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
