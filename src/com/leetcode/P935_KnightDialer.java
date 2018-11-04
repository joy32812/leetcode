package com.leetcode;

import java.util.Arrays;

public class P935_KnightDialer {

    private long MOD = 1000000000 + 7;


    /**
     * easy dp
     * @param N
     * @return
     */
    public int knightDialer(int N) {

        int num = 10;

        long[] dp = new long[num];
        Arrays.fill(dp, 1);

        int[][] from = new int[][]{
                {4, 6},
                {6, 8},
                {7, 9},
                {4, 8},
                {0, 3, 9},
                {},
                {0, 1, 7},
                {2, 6},
                {1, 3},
                {2, 4}
        };

        for (int i = 2; i <= N; i++) {
            long[] tmp = new long[num];

            for (int j = 0; j < num; j++) {
                for (int k = 0; k < from[j].length; k++) {
                    tmp[j] = (tmp[j] + dp[from[j][k]]) % MOD;
                }
            }

            dp = tmp;
        }


        long ans = 0;
        for (int i = 0; i < num; i++) {
            ans += dp[i];
            ans = ans % MOD;
        }

        return (int) ans;
    }



    public static void main(String[] args) {

    }

}
