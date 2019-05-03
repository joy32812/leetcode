package com.leetcode;

import java.util.Arrays;

public class P764_LargestPlusSign {


    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(grid[i], 1);

        for (int[] mine : mines) grid[mine[0]][mine[1]] = 0;

        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], N);

        // left && right
        for (int i = 0; i < N; i++) {
            int num = 0;
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    dp[i][j] = 0;
                    num = 0;
                    continue;
                }

                num ++;
                dp[i][j] = Math.min(dp[i][j], num);
            }

            num = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    dp[i][j] = 0;
                    num = 0;
                    continue;
                }
                num ++;
                dp[i][j] = Math.min(dp[i][j], num);
            }
        }

        // up && down

        for (int j = 0; j < N; j++) {
            int num = 0;
            for (int i = 0; i < N; i++) {
                if (grid[i][j] == 0) {
                    dp[i][j] = 0;
                    num = 0;
                    continue;
                }
                num ++;
                dp[i][j] = Math.min(dp[i][j], num);
            }

            num = 0;
            for (int i = N - 1; i > 0; i--) {
                if (grid[i][j] == 0) {
                    dp[i][j] = 0;
                    num = 0;
                    continue;
                }
                num ++;
                dp[i][j] = Math.min(dp[i][j], num);
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) ans = Math.max(ans, dp[i][j]);
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new P764_LargestPlusSign().orderOfLargestPlusSign(5, new int[][]{
                {4, 2}
        }));
    }


}
