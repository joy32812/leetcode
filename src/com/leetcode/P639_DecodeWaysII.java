package com.leetcode;

/**
 * Created by xiaoyuan on 11/08/2017.
 */
public class P639_DecodeWaysII {

    private static final int MOD = 1000000000 + 7;
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {return 0;}

        int n = s.length();
        long[][] dp = new long[n][10];


        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            for (int j = 1; j <= 9; j++) {
                if (ch != '*' && ch - '0' != j) {continue;}

                dp[i][j] = (dp[i][j] + getTotal(dp, i - 1)) % MOD;

                if (i - 1 >= 0) {
                    long last = getTotal(dp, i - 2);
                    dp[i][j] = (dp[i][j] + dp[i - 1][1] * last) % MOD;

                    if (j <= 6) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][2] * last) % MOD;
                    }
                }
            }

        }

        long ans = getTotal(dp, n - 1);
        return (int)ans;
    }

    private long getTotal(long[][] dp, int x) {
        if (x < 0 || x >= dp.length) {return 1;}
        long total = 0;
        for (int i = 1; i <= 9; i++) {
            total = (total + dp[x][i]) % MOD;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new P639_DecodeWaysII().numDecodings("***"));
        System.out.println(new P639_DecodeWaysII().numDecodings("1*"));
    }

}
