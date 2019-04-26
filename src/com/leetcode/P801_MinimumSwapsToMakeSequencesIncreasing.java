package com.leetcode;

import java.util.Arrays;

public class P801_MinimumSwapsToMakeSequencesIncreasing {

    public int minSwap(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) return 0;
        int n = A.length;

        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE / 2);

        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
            }

            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
            }
        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
    //[3,3,8,9,10]
    //[1,7,4,6,8]

    public static void main(String[] args) {
        System.out.println(new P801_MinimumSwapsToMakeSequencesIncreasing().minSwap(new int[]{3, 3, 8, 9, 10}, new int[]{1, 7, 4, 6, 8}));
    }

}
