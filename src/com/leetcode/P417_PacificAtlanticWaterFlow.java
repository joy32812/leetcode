package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 01/06/2017.
 */
public class P417_PacificAtlanticWaterFlow {

    int m;
    int n;
    int[][] h;
    int[][] flow;
    // 0 none
    // 1 P
    // 2 A
    // 3 Both
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {return ans;}

        m = matrix.length;
        n = matrix[0].length;
        h = matrix;

        flow = new int[m][n];
        for (int i = 0; i < m; i++) {
            flow[i][0] |= 1;
            flow[i][n - 1] |= 2;
        }
        for (int j = 0; j < n; j++) {
            flow[0][j] |= 1;
            flow[m - 1][j] |= 2;
        }

        bfs(1);
        bfs(2);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flow[i][j] == 3) {
                    ans.add(new int[]{i, j});
                }
            }
        }

        return ans;
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    private void bfs(int flag) {
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((flow[i][j] & flag) > 0) {
                    Q.add(i * n + j);
                }
            }
        }

        while (!Q.isEmpty()) {
            int tp = Q.poll();

            int x = tp / n;
            int y = tp % n;

            for (int i = 0; i < dx.length; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];

                if (tx < 0 || tx >= m || ty < 0 || ty >= n || h[x][y] > h[tx][ty] || (flow[tx][ty] & flag) > 0) {continue;}

                flow[tx][ty] |= flag;

                Q.add(tx * n + ty);
            }
        }
    }

}


