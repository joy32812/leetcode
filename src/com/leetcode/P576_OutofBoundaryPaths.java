package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 05/08/2017.
 */
public class P576_OutofBoundaryPaths {

    private static final int MOD = 1000000000 + 7;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int findPaths(int m, int n, int N, int i, int j) {

        long[][][] dp = new long[N + 1][m + 2][n + 2];
        dp[0][i + 1][j + 1] = 1;

        for (int step = 1; step <= N; step++) {
            for (int x = 1; x <= m; x++) {
                for (int y = 1;y <= n; y++) {
                    if (dp[step - 1][x][y] == -1) {continue;}
                    for (int k = 0; k < dx.length; k++) {
                        int tx = x + dx[k];
                        int ty = y + dy[k];

                        dp[step][tx][ty] = (dp[step][tx][ty] + dp[step - 1][x][y]) % MOD;
                    }
                }
            }
        }


        long ans = 0;
        for (int step = 1; step <= N; step++) {
            for (int x = 0; x < m + 2; x++) {
                for (int y = 0; y < n + 2; y++) {
                    if (x == 0 || x == m + 1 || y == 0 || y == n + 1) {
                        ans = (ans + dp[step][x][y]) % MOD;
                    }
//                    System.out.print(dp[step][x][y] + " ");
                }
//                System.out.println();
            }
//            System.out.println();
        }

        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(new P576_OutofBoundaryPaths().findPaths(2, 2, 2, 0, 0));
        System.out.println(new P576_OutofBoundaryPaths().findPaths(8, 50, 23, 5, 26));
    }

}
