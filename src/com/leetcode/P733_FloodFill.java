package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xiaoyuan on 26/11/2017.
 */
public class P733_FloodFill {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int color = image[sr][sc];

        int R = image.length;
        int C = image[0].length;

        Queue<int[]> Q = new LinkedList<>();
        image[sr][sc] = newColor;
        Q.add(new int[]{sr, sc});

        boolean[][] visit = new boolean[R][C];
        visit[sr][sc] = true;

        while (!Q.isEmpty()) {
            int[] t = Q.poll();

            int x = t[0];
            int y = t[1];

            for (int i = 0; i < dx.length; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C || image[nx][ny] != color || visit[nx][ny]) continue;

                visit[nx][ny] = true;
                image[nx][ny] = newColor;
                Q.add(new int[]{nx, ny});
            }

        }

        return image;
    }


    public static void main(String[] args) {

    }

}
