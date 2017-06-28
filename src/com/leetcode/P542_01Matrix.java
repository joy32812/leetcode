package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xiaoyuan on 28/06/2017.
 */
public class P542_01Matrix {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int[][] updateMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {return new int[0][];}

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[m][n];

        Queue<Integer> Q = new LinkedList<>();
        Set<Integer> inQ = new HashSet<>();


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = Integer.MAX_VALUE;
                if (matrix[i][j] == 0) {
                    ans[i][j] = 0;
                    Q.add(i * n + j);
                    inQ.add(i * n + j);
                }
            }
        }

        while (!Q.isEmpty()) {
            int tp = Q.poll();
            inQ.remove(tp);

            int x = tp / n;
            int y = tp % n;

            for (int i = 0; i < dx.length; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];

                if (tx < 0 || tx >= m || ty < 0 || ty >= n || ans[tx][ty] <= ans[x][y] + 1) {continue;}

                ans[tx][ty] = ans[x][y] + 1;
                if (!inQ.contains(tx * n + ty)) {
                    Q.add(tx * n + ty);
                    inQ.add(tx * n + ty);
                }
            }

        }

        return ans;

    }

}
