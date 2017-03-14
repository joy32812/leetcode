package com.leetcode;

/**
 * Created by xiaoyuan on 14/03/2017.
 */
public class P123_BestTimetoBuyandSellStockIII {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) { return 0;}

        int n = prices.length;

        int[] fromLeft = new int[n];
        int[] fromRight = new int[n];

        fromLeft[0] = 0;
        int begin = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] >= prices[i - 1]) {continue;}

            max = Math.max(max, prices[i - 1] - prices[begin]);
            begin = i;
            fromLeft[i] = max;
        }

        max = Math.max(max, prices[n - 1] - prices[begin]);
        fromLeft[n - 1] = max;



        begin = n - 1;
        max = 0;
        fromRight[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] <= prices[i + 1]) {continue;}

            max = Math.max(max, prices[begin] - prices[i]);
            begin = i;
            fromRight[i] = max;
        }
        max = Math.max(max, prices[begin] - prices[0]);
        fromRight[0] = max;


        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, getValue(fromLeft, i) + getValue(fromRight, i + 1));
        }

        return ans;
    }

    private int getValue(int[] arr, int i) {
        if (i < 0 || i >= arr.length) {return 0;}

        return arr[i];
    }

    public static void main(String[] args) {
        System.out.println(new P123_BestTimetoBuyandSellStockIII().maxProfit(new int[]{1,2,3,5,9,1,100}));
    }

}
