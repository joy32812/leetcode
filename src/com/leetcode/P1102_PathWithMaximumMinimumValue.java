package com.leetcode;

import java.util.*;

public class P1102_PathWithMaximumMinimumValue {


    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int maximumMinimumPath(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(ans[i], -1);


        Queue<Integer> Q = new ArrayDeque<>();
        Set<Integer> inQ = new HashSet<>();

        Q.add(0);
        ans[0][0] = A[0][0];
        inQ.add(0);


        while (!Q.isEmpty()) {
            int now = Q.poll();
            inQ.remove(now);

            int x = now / m;
            int y = now % m;

            for (int k = 0; k < dx.length; k++) {
                int tx = x + dx[k];
                int ty = y + dy[k];

                if (tx < 0 || tx >= n || ty < 0 || ty >= m) continue;;

                int res = Math.min(ans[x][y], A[tx][ty]);

                if (res > ans[tx][ty]) {
                    ans[tx][ty] = res;

                    int key = tx * m + ty;
                    if (!inQ.contains(key)) {
                        Q.add(key);
                        inQ.add(key);
                    }
                }

            }

        }

        return ans[n - 1][m - 1];

    }


    public static void main(String[] args) {
        System.out.println(new P1102_PathWithMaximumMinimumValue().maximumMinimumPath(new int[][]{
//                {5,4,5},{1,2,6},{7,4,6}
                {2,2,1,2,2,2},{1,2,2,2,1,2}
        }));
    }

}
