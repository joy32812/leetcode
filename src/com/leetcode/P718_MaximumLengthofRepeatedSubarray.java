package com.leetcode;

/**
 * Created by xiaoyuan on 29/10/2017.
 */
public class P718_MaximumLengthofRepeatedSubarray {

    public int findLength(int[] A, int[] B) {

        int m = A.length;
        int n = B.length;

        int[][] dp = new int[m + 1][n + 1];


        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (A[i] != B[j]) continue;

                dp[i + 1][j + 1] = dp[i][j] + 1;

                ans = Math.max(ans, dp[i + 1][j + 1]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P718_MaximumLengthofRepeatedSubarray().findLength(new int[]{1, 2, 3, 2, 1, 4}, new int[]{3, 2, 1, 4, 7}));
    }

}
