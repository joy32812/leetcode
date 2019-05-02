package com.leetcode;

import java.util.Arrays;

public class P877_StoneGame {

    int[] sum;
    int[][] dp;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        sum = new int[n];

        // prefix sum
        for (int i = 0; i < n; i++) sum[i] = (i - 1 >= 0 ? sum[i - 1] : 0) + piles[i];

        int max = getStone(piles, 0, n - 1);
        return max > sum[n - 1] / 2;
    }

    private int getStone(int[] piles, int l, int r) {
        if (l == r) return dp[l][r] = piles[l];
        if (dp[l][r] > 0) return dp[l][r];

        int total = sum[r] - (l - 1 >= 0 ? sum[l - 1] : 0);
        int min = Math.min(getStone(piles, l + 1, r), getStone(piles, l, r - 1));
        return dp[l][r] = total - min;
    }

}
