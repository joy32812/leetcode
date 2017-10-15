package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xiaoyuan on 01/10/2017.
 */
public class P688_KnightProbabilityinChessboard {

    int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    int[] dy = {-1, -2, -2, -1,1, 2, 2, 1};
    public double knightProbability(int N, int K, int r, int c) {

        double[][] dp = new double[N][N];
        dp[r][c] = 1;

        for (int step = 1; step <= K; step++) {
            double[][] tmp = new double[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dp[i][j] == 0) continue;;

                    for (int k = 0; k < dx.length; k++) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];

                        if (tx < 0 || tx >= N || ty < 0 || ty >= N) continue;
                        tmp[tx][ty] += dp[i][j] / 8.0;
                    }
                }
            }

            dp = tmp;
        }

        double ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans += dp[i][j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P688_KnightProbabilityinChessboard().knightProbability(3, 2, 0, 0));
    }


}
