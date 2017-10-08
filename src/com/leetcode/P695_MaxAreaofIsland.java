package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xiaoyuan on 08/10/2017.
 */
public class P695_MaxAreaofIsland {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};


    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, work(grid, i, j));
                }
            }
        }

        return ans;
    }

    private int work(int[][] grid, int x, int y) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Integer> Q = new LinkedList<>();
        Set<Integer> inQ = new HashSet<>();

        Q.add(x * n + y);
        inQ.add(x * n + y);

        while (!Q.isEmpty()) {
            int tp = Q.poll();

            int nx = tp / n;
            int ny = tp % n;
            grid[nx][ny] = 0;

            for (int i = 0; i < dx.length; i++) {
                int tx = nx + dx[i];
                int ty = ny + dy[i];

                if (tx < 0 || tx >= m || ty < 0 || ty >= n || grid[tx][ty] != 1) continue;

                int key = tx * n + ty;
                if (!inQ.contains(key)) {
                    inQ.add(key);
                    Q.add(key);
                }
            }

        }


        return inQ.size();
    }

    public static void main(String[] args) {
        System.out.println(new P695_MaxAreaofIsland().maxAreaOfIsland(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 0, 1, 1},
        }));
    }

}
