package com.leetcode;

public class P790_DominoandTrominoTiling {

    long mod = (int) (1e9 + 7);
    public int numTilings(int N) {
        if (N <= 0) return 0;

        long[][] dp = new long[N + 1][5];
        dp[0][4] = 1;


        for (int i = 1; i <= N; i++) {
            // 0
            if (i - 2 >= 0) {
                dp[i][0] += dp[i - 2][4];
            }
            dp[i][0] += dp[i - 1][1];
            dp[i][0] %= mod;


            // 1
            if (i - 2 >= 0) {
                dp[i][1] += dp[i - 2][4];
            }
            dp[i][1] += dp[i - 1][0];
            dp[i][1] %= mod;

//            // 2
//            if (i - 2 >= 0) {
//                dp[i][2] += dp[i - 2][4];
//            }
//
//
//            // 3
//            if (i - 2 >= 0) {
//                dp[i][3] += dp[i - 2][4];
//            }


            // 4
            if (i - 2 >= 0) {
                dp[i][4] += dp[i - 2][4];
            }
            dp[i][4] += dp[i - 1][0];
            dp[i][4] += dp[i - 1][1];
            dp[i][4] += dp[i - 1][4];
            dp[i][4] %= mod;
        }

        return (int) dp[N][4];
    }


    public static void main(String[] args) {
        System.out.println(new P790_DominoandTrominoTiling().numTilings(3));
        System.out.println(new P790_DominoandTrominoTiling().numTilings(5));
        System.out.println(new P790_DominoandTrominoTiling().numTilings(30));
    }

}
