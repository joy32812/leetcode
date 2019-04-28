package com.leetcode;

public class P1035_UncrossedLines {

    /**
     * DP O(mn)
     * similar to LCS
     * dp[i][j] = Math(dp[i - 1][j], dp[i][j - 1])
     * a[i] == a[j]    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1)
     * @param A
     * @param B
     * @return
     */
    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 0;
                if (i - 1 >= 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if (j - 1 >= 0) dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);

                if (A[i] == B[j]) {
                    dp[i][j] = Math.max(dp[i][j], 1);
                    if (i - 1 >= 0 && j - 1 >= 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
    }

}
