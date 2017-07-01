package com.leetcode;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P629_KInversePairsArray {

    private static final int MOD = 1000000000 + 7;
    public int kInversePairs(int n, int k) {
        if (k == 0) {return 1;}
        if (k == n * (n - 1) / 2) {return 1;}
        if (k > n * (n - 1) / 2) {return 0;}

        long[][] dp = new long[n + 1][k + 1];
        long[][] sum = new long[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            sum[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                if (j > i * (i - 1) / 2) {
                    dp[i][j] = 0;
                } else {
                    int rr = j;
                    int ll = Math.max(0, j - i + 1);
                    dp[i][j] = sum[i - 1][rr] - (ll - 1 >= 0 ? sum[i - 1][ll - 1] : 0);
                }
                sum[i][j] = sum[i][j - 1] + dp[i][j];

                dp[i][j] = (MOD + dp[i][j]) % MOD;
                sum[i][j] = (MOD + sum[i][j]) % MOD;
            }
        }

        return (int)((dp[n][k] + MOD) % MOD);
    }

}
