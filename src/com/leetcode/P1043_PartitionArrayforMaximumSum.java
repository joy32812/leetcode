package com.leetcode;

import java.util.Arrays;

public class P1043_PartitionArrayforMaximumSum {

    public int maxSumAfterPartitioning(int[] A, int K) {

        int n = A.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int max = A[i];
            for (int j = i - 1; j >= -1 && (i - j <= K); j--) {
                dp[i] = Math.max(dp[i], (j >= 0 ? dp[j] : 0) + max * (i - j));
                if (j >= 0) max = Math.max(max, A[j]);
            }
        }


        return Arrays.stream(dp).max().getAsInt();
    }

    public int maxSumAfterPartitioning2(int[] A, int K) {

        int n = A.length;
        int[][] dp = new int[K + 1][n];
        for (int i = 0; i < n; i++) dp[1][i] = A[i] + (i - 1 >=0 ? dp[1][i - 1] : 0);


        for (int k = 2; k <= K; k++) {
            for (int i = 0; i < n; i++) {

                int max = 0;
                for (int j = i; j >= 0 && j >= i - k + 1; j--) {
                    int now = j - 1 >= 0 ? dp[k][j - 1] : 0;
                    max = Math.max(max, A[j]);
                    dp[k][i] = Math.max(dp[k][i], max * (i - j + 1) + now);
                }
            }
        }


        return dp[K][n - 1];
    }

    public static void main(String[] args) {

        System.out.println(new P1043_PartitionArrayforMaximumSum().maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));

    }

}
