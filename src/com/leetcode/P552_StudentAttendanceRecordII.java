package com.leetcode;

/**
 * Created by xiaoyuan on 29/06/2017.
 */
public class P552_StudentAttendanceRecordII {

    private long MOD = 1000000000 + 7;
    public int checkRecord(int n) {
        if (n == 0) {return 0;}

        long[][] dp = new long[n][7];
        dp[0][0] = 1; // A
        dp[0][1] = 0; // P
        dp[0][2] = 0; // L
        dp[0][3] = 0; // LL

        dp[0][4] = 1; // P
        dp[0][5] = 1; // L
        dp[0][6] = 0; // LL

        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][4] + dp[i - 1][5] + dp[i - 1][6]) % MOD;

            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % MOD;

            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;

            dp[i][3] = dp[i - 1][2];



            dp[i][4] = (dp[i - 1][4] + dp[i - 1][5] + dp[i - 1][6]) % MOD;

            dp[i][5] = dp[i - 1][4];

            dp[i][6] = dp[i - 1][5];
        }

        long ans = 0;
        for (int i = 0; i < dp[0].length; i++) {
            ans = (ans + MOD + dp[n - 1][i]) % MOD;
        }

        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(new P552_StudentAttendanceRecordII().checkRecord(188));
    }

}
