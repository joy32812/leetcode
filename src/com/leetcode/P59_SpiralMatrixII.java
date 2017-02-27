package com.leetcode;

/**
 * Created by xiaoyuan on 27/02/2017.
 * easy
 */
public class P59_SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }

        int[][] ans = new int[n][n];
        boolean[][] visit = new boolean[n][n];

        int x = 0;
        int y = 0;
        int total = n * n;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int pos = 0;

        for (int i = 1; i <= total; i++) {
            ans[x][y] = i;
            visit[x][y] = true;

            int mx = x + dx[pos];
            int my = y + dy[pos];

            if (mx < 0 || mx >= n || my < 0 || my >= n || visit[mx][my]) {
                pos = (pos + 1) % 4;
            }

            x = x + dx[pos];
            y = y + dy[pos];
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] ans = new P59_SpiralMatrixII().generateMatrix(3);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
