package com.leetcode;

import java.util.concurrent.ForkJoinPool;

public class P978_LongestTurbulentSubarray {


    public int maxTurbulenceSize(int[] A) {

        int n = A.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 1;
        dp[0][1] = 1;

        int ans = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;

            if (A[i] > A[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
            }

            if (A[i] < A[i - 1]) {
                dp[i][1] = dp[i - 1][0] + 1;
            }

            ans = Math.max(ans, dp[i][0]);
            ans = Math.max(ans, dp[i][1]);
        }

        return ans;
    }


    public static void main(String[] args) {

    }

}
