package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class P1031_NumberofEnclaves {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int numEnclaves(int[][] A) {

        int m = A.length;
        int n = A[0].length;

        int total = 0;

        Queue<Integer> Q = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) total ++;
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (A[i][j] == 1) {
                        Q.add(i * n + j);
                        visit.add(i * n + j);
                    }
                }
            }
        }

        if (m == 1 || n == 1) return 0;

        while (!Q.isEmpty()) {
            int now = Q.poll();

            int x = now / n;
            int y = now % n;

            for (int k = 0; k < dx.length; k++) {
                int tx = x + dx[k];
                int ty = y + dy[k];

                if (tx < 0 | tx >= m || ty < 0 || ty >= n) continue;
                if (A[tx][ty] == 0) continue;
                if (visit.contains(tx * n + ty)) continue;

                Q.add(tx * n + ty);
                visit.add(tx * n + ty);
            }

        }


        return total - visit.size();
    }


    public static void main(String[] args) {

    }

}
