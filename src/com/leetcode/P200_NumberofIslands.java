package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 29/03/2017.
 * easy bfs
 * traverse
 */
public class P200_NumberofIslands {

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {return 0;}

        int m = grid.length;
        int n = grid[0].length;

        int[][] mark = new int[m][n];
        int ans = 0;

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && mark[i][j] == 0) {
                    ans++;

                    bfs(grid, mark, i, j, ans);
                }
            }
        }

        return ans;
    }

    private void bfs(char[][] grid, int[][] mark, int x, int y, int cnt) {
        int m = grid.length;
        int n = grid[0].length;

        mark[x][y] = cnt;
        Queue<Integer> Q = new LinkedList<Integer>();
        Set<Integer> inQSet = new HashSet<Integer>();
        int key = x * n + y;
        Q.add(key);
        inQSet.add(key);

        while (!Q.isEmpty()) {
            int p = Q.poll();
            int nx = p / n;
            int ny = p % n;

            for (int i = 0; i < dx.length; i++) {
                int tx = nx + dx[i];
                int ty = ny + dy[i];

                if (tx < 0 || tx >= m || ty < 0 || ty >= n || mark[tx][ty] > 0 || grid[tx][ty] == '0') {
                    continue;
                }

                mark[tx][ty] = cnt;
                if (!inQSet.contains(tx * n + ty)) {
                    Q.add(tx * n + ty);
                    inQSet.add(tx * n + ty);
                }
            }
        }

    }

}
