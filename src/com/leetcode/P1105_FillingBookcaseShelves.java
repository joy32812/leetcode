package com.leetcode;

import java.util.Arrays;

public class P1105_FillingBookcaseShelves {


    /**
     * O(N^2) DP
     *
     * @param books
     * @param shelf_width
     * @return
     */
    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int[] bi = books[i];
            dp[i] = Math.min(dp[i], getValue(dp, i - 1) + bi[1]);

            int now = bi[0];
            int H = bi[1];
            for (int j = i - 1; j >= 0; j--) {
                int[] bj = books[j];
                now += bj[0];
                H = Math.max(H, bj[1]);

                if (now > shelf_width) break;

                dp[i] = Math.min(dp[i], getValue(dp, j - 1) + H);
            }
        }

        return dp[n - 1];
    }

    private int getValue(int[] dp, int i) {
        if (i < 0) return 0;
        return dp[i];
    }


    public static void main(String[] args) {
    }
}
