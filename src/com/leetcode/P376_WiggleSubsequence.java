package com.leetcode;

/**
 * Created by xiaoyuan on 18/05/2017.
 */
public class P376_WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {return nums.length;}

        int ans = 1;
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 1; // big
        dp[0][1] = 1; // small

        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                } else if (nums[i] < nums[j]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
            }

            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P376_WiggleSubsequence().wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
    }

}
