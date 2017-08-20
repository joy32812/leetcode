package com.leetcode;

/**
 * Created by xiaoyuan on 20/08/2017.
 */
public class P661_ImageSmoother {

    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {return new int[][]{};}

        int m = M.length;
        int n = M[0].length;
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = getVal(M, i, j);
            }
        }

        return ans;
    }

    private int getVal(int[][] M, int x, int y) {

        int sum = 0;
        int num = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int dx = x + i;
                int dy = y + j;

                if (dx < 0 || dx >= M.length || dy < 0 || dy >= M[0].length) {continue;}

                num++;
                sum += M[dx][dy];
            }
        }

        return (int)Math.floor((0.0 + sum) / num);
    }

}
