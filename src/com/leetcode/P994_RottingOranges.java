package com.leetcode;

import java.util.*;

public class P994_RottingOranges {


    int[] tx = {0, 0, 1, -1};
    int[] ty = {1, -1, 0, 0};

    /**
     * bfs
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dis[i], Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || grid[i][j] == 1) continue;

                dis[i][j] = 0;

                Queue<Integer> Q = new ArrayDeque<>();
                Set<Integer> inQ = new HashSet<>();
                Q.add(i * n + j);
                inQ.add(i * n + j);

                while (!Q.isEmpty()) {
                    int tp = Q.poll();
                    inQ.remove(tp);

                    int x = tp / n;
                    int y = tp % n;


                    for (int k = 0; k < tx.length; k++) {
                        int nx = x + tx[k];
                        int ny = y + ty[k];

                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                        if (grid[nx][ny] != 1) continue;

                        if (dis[nx][ny] > dis[x][y] + 1) {
                            dis[nx][ny] = dis[x][y] + 1;

                            int vv = nx * n + ny;
                            if (!inQ.contains(vv)) {
                                Q.add(nx * n + ny);
                                inQ.add(nx * n + ny);
                            }
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;
                ans = Math.max(ans, dis[i][j]);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }


    public static void main(String[] args) {

    }
}
