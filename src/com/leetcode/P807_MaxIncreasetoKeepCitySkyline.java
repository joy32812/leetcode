package com.leetcode;

import javax.sql.rowset.FilteredRowSet;

public class P807_MaxIncreasetoKeepCitySkyline {

    /**
     * easy
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int n = grid.length;
        int[] row = new int[n];
        int[] col = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) ans += Math.min(row[i], col[j]) - grid[i][j];
        }
        return ans;

    }

}
