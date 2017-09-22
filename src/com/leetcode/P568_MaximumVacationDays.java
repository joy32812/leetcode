package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 22/09/2017.
 */
public class P568_MaximumVacationDays {

    public int maxVacationDays(int[][] flights, int[][] days) {

        int n = flights.length; // city
        int w = days[0].length; // week


        int[][] dp = new int[w][n];
        for (int i = 0; i < w; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = days[0][0];

        for (int j = 1; j < n; j++) {
            if (flights[0][j] == 1) {dp[0][j] = days[j][0];}
        }

        for (int i = 1; i < w; i++) {
            for (int j = 0; j < n; j++) {

                for (int k = 0; k < n; k++) {
                    if (dp[i - 1][k] == -1) continue;
                    if (j !=k && flights[k][j] == 0) continue;

                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + days[j][i]);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < w; i++){
            for (int j = 0; j < n; j++) ans = Math.max(ans, dp[i][j]);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P568_MaximumVacationDays().maxVacationDays(new int[][]{
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0},
        }, new int[][]{
                {1, 3, 1},
                {6, 0, 3},
                {3, 3, 3},
        }));

        System.out.println(new P568_MaximumVacationDays().maxVacationDays(new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
        }, new int[][]{
                {1, 1, 1},
                {7, 7, 7},
                {7, 7, 7},
        }));


        System.out.println(new P568_MaximumVacationDays().maxVacationDays(new int[][]{
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0},
        }, new int[][]{
                {7, 0, 0},
                {0, 7, 0},
                {0, 0, 7},
        }));
    }

}
