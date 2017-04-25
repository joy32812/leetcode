package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xiaoyuan on 25/04/2017.
 */
public class P302_SmallestRectangleEnclosingBlackPixels {

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;

        boolean[][] mark = new boolean[m][n];

        int minX = x;
        int maxX = x;

        int minY = y;
        int maxY = y;

        Queue<Integer> Q = new LinkedList<>();
        Q.add(x * n + y);

        Set<Integer> inQ = new HashSet<>();
        inQ.add(x * n + y);

        mark[x][y] = true;

        while (!Q.isEmpty()) {
            int tp = Q.poll();
            inQ.remove(tp);

            int nx = tp / n;
            int ny = tp % n;

            for (int i = 0; i < dx.length; i++) {
                int tx = nx + dx[i];
                int ty = ny + dy[i];

                if (tx < 0 || tx >= m || ty < 0 || ty >= n || mark[tx][ty] || image[tx][ty] == '0') {continue;}

                mark[tx][ty] = true;
                int v = tx * n + ty;
                if (!inQ.contains(v)) {
                    Q.add(v);
                    inQ.add(v);
                }

                minX = Math.min(minX, tx);
                maxX = Math.max(maxX, tx);

                minY = Math.min(minY, ty);
                maxY = Math.max(maxY, ty);
            }
        }

        return (maxX - minX + 1) * (maxY - minY + 1);
    }

    public static void main(String[] args) {
        System.out.println(new P302_SmallestRectangleEnclosingBlackPixels().minArea(new char[][]{
                {'0', '0', '1', '0'},
                {'0', '1', '1', '0'},
                {'0', '1', '0', '0'}
        }, 0, 2));
    }

}
