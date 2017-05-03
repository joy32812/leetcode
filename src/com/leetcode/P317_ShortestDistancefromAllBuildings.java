package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 03/05/2017.
 */
public class P317_ShortestDistancefromAllBuildings {

    private int m, n;
    public int shortestDistance(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        List<Integer> buildings = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {buildings.add(i * n + j);}
            }
        }

        List<int[][]> result = new ArrayList<>();

        for (int build: buildings) {
            int x = build / n;
            int y = build % n;

            result.add(getDistance(grid, x, y));
        }


        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int tmp = 0;
                    for (int k = 0; k < buildings.size(); k++) {
                        if (result.get(k)[i][j] == Integer.MAX_VALUE) {
                            tmp = Integer.MAX_VALUE;
                            break;
                        }

                        tmp += result.get(k)[i][j];
                    }

                    ans = Math.min(ans, tmp);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private int[][] getDistance(int[][] grid, int x, int y) {

        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dis[i][j] = Integer.MAX_VALUE;
            }
        }

        dis[x][y] = 0;
        Queue<Integer> Q = new LinkedList<>();
        Set<Integer> inQ = new HashSet<>();
        Q.add(x * n + y);
        inQ.add(x * n + y);

        while (!Q.isEmpty()) {
            int tp = Q.poll();
            inQ.remove(tp);

            int nx = tp / n;
            int ny = tp % n;

            for (int i = 0; i < dx.length; i++) {
                int tx = nx + dx[i];
                int ty = ny + dy[i];

                if (tx < 0 || tx >= m || ty < 0 || ty >= n || grid[tx][ty] == 2 || grid[tx][ty] == 1 || dis[tx][ty] <= dis[nx][ny] + 1) {
                    continue;
                }

                dis[tx][ty] = dis[nx][ny] + 1;
                int key = tx * n + ty;
                if (!inQ.contains(key)) {
                    Q.add(key);
                    inQ.add(key);
                }
            }
        }


        return dis;
    }

    public static void main(String[] args) {
        System.out.println(new P317_ShortestDistancefromAllBuildings().shortestDistance(new int[][]{
                {0, 2, 1},
                {1, 0, 2},
                {0, 1, 0},
        }));
    }

}
