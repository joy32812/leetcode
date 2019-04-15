package com.leetcode;

public class P813_LargestSumofAverages {

    /**
     * medium
     *
     * dp[i][k] means for the first i elements, divided by k group
     * the best we can get
     * @param A
     * @param K
     * @return
     */
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;

        int[] sum = new int[n];
        for (int i = 0; i < n; i++) sum[i] = (i - 1 >= 0 ? sum[i - 1] : 0) + A[i];

        double[][] avg = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                avg[i][j] = (0.0 + sum[j] - (i - 1 >= 0 ? sum[i - 1] : 0)) / (j - i + 1);
            }
        }


        double[][] dp = new double[n][K + 1];
        for (int i = 0; i < n; i++) {
            dp[i][1] = avg[0][i];

            for (int k = 2; k <= K; k ++) {
                if (k > (i + 1)) break;

                for (int j = 0; j < i; j++) {
                    dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + avg[j + 1][i]);
                }
            }
        }

        return dp[n - 1][K];
    }

}
