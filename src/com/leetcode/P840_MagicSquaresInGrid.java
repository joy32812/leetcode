package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P840_MagicSquaresInGrid {

    int[][] G;
    public int numMagicSquaresInside(int[][] grid) {
        if (grid == null || grid.length < 3 || grid[0].length < 3) return 0;

        G = grid;

        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        for (int i = 0; i + 2 < m; i++) {
            for (int j = 0; j + 2 < n; j++) {
                Set<Integer> uniqSet = new HashSet<>();
                for (int x = i; x < i + 3; x ++) {
                    for (int y = j; y < j + 3; y ++) {
                        if (grid[x][y] >= 1 && grid[x][y] <= 9) uniqSet.add(grid[x][y]);
                    }
                }
                if (uniqSet.size() != 9) continue;


                Set<Integer> result = new HashSet<>();
                result.add(compute(i, j, 0, 1));
                result.add(compute(i + 1, j, 0, 1));
                result.add(compute(i + 2, j, 0, 1));


                result.add(compute(i, j, 1, 0));
                result.add(compute(i, j + 1, 1, 0));
                result.add(compute(i, j + 2, 1, 0));

                result.add(compute(i, j, 1, 1));
                result.add(compute(i, j + 2, 1, -1));

                if (result.size() == 1) ans ++;
            }
        }

        return ans;
    }

    private Integer compute(int i, int j, int dx, int dy) {
        int sum = 0;
        for (int k = 0; k < 3; k++) {
            sum += G[i][j];
            i += dx;
            j += dy;
        }

        return sum;
    }

}
