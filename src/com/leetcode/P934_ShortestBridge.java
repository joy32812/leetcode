package com.leetcode;

import java.util.*;

public class P934_ShortestBridge {



    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    public int shortestBridge(int[][] A) {
        if (A == null || A.length == 0) return 0;

        int m = A.length;
        int n = A[0].length;

        int[][] color = new int[m][n];

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) continue;
                if (color[i][j] != 0) continue;;

                cnt ++;


                Queue<Integer> Q = new LinkedList<>();

                Q.add(i * n + j);
                color[i][j] = cnt;

                while (!Q.isEmpty()) {
                    int now = Q.poll();
                    int x = now / n;
                    int y = now % n;

                    for (int k = 0; k < dx.length; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                        if (A[nx][ny] == 0) continue;
                        if (color[nx][ny] != 0) continue;

                        color[nx][ny] = cnt;
                        Q.add(nx * n + ny);
                    }
                }
            }
        }


        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0;j < n; j++) {
                if (color[i][j] == 1) one.add(i * n + j);
                if (color[i][j] == 2) two.add(i * n + j);
            }
        }


        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < one.size(); i++) {

            int ax = one.get(i) / n;
            int ay = one.get(i) % n;

            for (int j = 0; j < two.size(); j++) {

                int bx = two.get(j) / n;
                int by = two.get(j) % n;

                int nowVal = 0;
                if (ax != bx) nowVal += Math.abs(ax - bx);
                if (ay != by) nowVal += Math.abs(ay - by);

                ans = Math.min(ans, nowVal - 1);
            }
        }

        return ans;
    }



    public static void main(String[] args) {

        int[][] A = new int[][]{
                {1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}
        };
        System.out.println(new P934_ShortestBridge().shortestBridge(A));

    }

}
