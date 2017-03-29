package com.leetcode;

/**
 * Created by xiaoyuan on 29/03/2017.
 * just dp
 */
public class P198_HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) {return 0;}
        int n = nums.length;

        int[][] dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i - 1] + dp[i - 1][0];
        }

        return Math.max(dp[n][0], dp[n][1]);
    }

    public static void main(String[] args) {
        System.out.println(new P198_HouseRobber().rob(new int[]{1, 10, 1020, 1000}));
    }

}
