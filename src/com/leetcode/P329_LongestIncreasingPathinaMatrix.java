package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xiaoyuan on 07/05/2017.
 */
public class P329_LongestIncreasingPathinaMatrix {

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {return 0;}

        int m = matrix.length;
        int n = matrix[0].length;


        Queue<Integer> Q = new LinkedList<>();
        Set<Integer> inQ = new HashSet<>();
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (leThanNeigbor(matrix, i, j)) {
                    ans[i][j] = 1;
                    Q.add(i * n + j);
                    inQ.add(i * n + j);
                }
            }
        }


        // bfs
        while (!Q.isEmpty()) {
            int tp = Q.poll();
            inQ.remove(tp);

            int x = tp / n;
            int y = tp % n;

            for (int i = 0; i < dx.length; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];

                if (tx < 0 || tx >= matrix.length || ty < 0 || ty >= matrix[0].length) {continue;}
                if (matrix[tx][ty] <= matrix[x][y]) {continue;}
                if (ans[tx][ty] >= ans[x][y] + 1) {continue;}

                ans[tx][ty] = ans[x][y] + 1;
                int key = tx * n + ty;
                if (!inQ.contains(key)) {
                    Q.add(key);
                    inQ.add(key);
                }
            }
        }


        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, ans[i][j]);
            }
        }

        return res;
    }

    private boolean leThanNeigbor(int[][] matrix, int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if (tx < 0 || tx >= matrix.length || ty < 0 || ty >= matrix[0].length) {continue;}

            if (matrix[x][y] > matrix[tx][ty]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P329_LongestIncreasingPathinaMatrix().longestIncreasingPath(
                new int[][]{
                        {9, 9, 4},
                        {6, 6, 8},
                        {2, 1, 1}
                }
        ));
    }

}
