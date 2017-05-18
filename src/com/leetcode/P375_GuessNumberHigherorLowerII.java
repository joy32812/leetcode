package com.leetcode;

/**
 * Created by xiaoyuan on 18/05/2017.
 */

public class P375_GuessNumberHigherorLowerII {

    public int getMoneyAmount(int n) {

        int[][] dp = new int[n + 1][ n + 1];

        return DP(dp, 1, n);
    }

    private int DP(int[][] dp, int l, int r) {
        if (l >= r) {return 0;}
        if (dp[l][r] != 0) {return dp[l][r];}

        int ans = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            ans = Math.min(ans, i + Math.max(DP(dp, l, i - 1), DP(dp, i + 1, r)));
        }

        dp[l][r] = ans;
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new P375_GuessNumberHigherorLowerII().getMoneyAmount(100));
//        System.out.println(new P375_GuessNumberHigherorLowerII().getTimes(7));
    }
}
