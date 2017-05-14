package com.leetcode;

/**
 * Created by xiaoyuan on 14/05/2017.
 */
public class P361_BombEnemy {

    public int maxKilledEnemies(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {return 0;}

        int m = grid.length;
        int n = grid[0].length;

        int[][] left = getHorEnemy(grid, 0, n - 1, 1);
        int[][] right = getHorEnemy(grid, n - 1, 0, -1);

        int[][] up = getVerEnemy(grid, 0, m - 1, 1);
        int[][] down = getVerEnemy(grid, m - 1, 0, -1);

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    ans = Math.max(ans, up[i][j] + down[i][j] + left[i][j] + right[i][j]);
                }
            }
        }

        return ans;
    }

    private int[][] getHorEnemy(char[][] grid, int fromY, int toY, int step) {
        int[][] res = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            int now = 0;
            for (int j = fromY; ; j += step) {
                if (step < 0 && j < toY) {break;}
                if (step > 0 && j > toY) {break;}
                res[i][j] = now;
                if (grid[i][j] == 'W') {
                    now = 0;
                } else if (grid[i][j] == 'E') {
                    now++;
                }
            }
        }
        return res;
    }

    private int[][] getVerEnemy(char[][] grid, int fromX, int toX, int step) {
        int[][] res = new int[grid.length][grid[0].length];

        for (int j = 0; j < grid[0].length; j++) {
            int now = 0;
            for (int i = fromX; ; i += step) {
                if (step < 0 && i < toX) {break;}
                if (step > 0 && i > toX) {break;}
                res[i][j] = now;
                if (grid[i][j] == 'W') {
                    now = 0;
                } else if (grid[i][j] == 'E') {
                    now++;
                }
            }
        }
        return res;
    }


}
