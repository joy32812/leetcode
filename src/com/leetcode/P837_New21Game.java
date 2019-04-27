package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P837_New21Game {

    /**
     * DP with prefix/suffix sum
     * @param N
     * @param K
     * @param W
     * @return
     */
    public double new21Game(int N, int K, int W) {


        double[] dp = new double[N + 1];
        double now = 0;
        for (int i = N; i >= 0; i--) {
            if (i >= K && i <= N) dp[i] = 1;
            else dp[i] = now / W;

            if (i + W < dp.length) now -= dp[i + W];
            now += dp[i];
        }

        return dp[0];
    }


    public static void main(String[] args) {
        System.out.println(new P837_New21Game().new21Game(10, 1, 10));
        System.out.println(new P837_New21Game().new21Game(6, 1, 10));
        System.out.println(new P837_New21Game().new21Game(21, 17, 10));
    }

}
