package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xiaoyuan on 01/08/2017.
 */
public class P490_TheMaze {

    int R;
    int C;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        R = maze.length;
        C = maze[0].length;

        int[][] left = getLeft(maze);
        int[][] right = getRight(maze);
        int[][] up = getUp(maze);
        int[][] down = getDown(maze);


//        print(left);
//        print(right);
//        print(up);
//        print(down);

        Queue<Integer> Q = new LinkedList<>();
        Set<Integer> inQ = new HashSet<>();

        int now = start[0] * C + start[1];
        Q.add(now);
        inQ.add(now);

        while (!Q.isEmpty()) {
            int tp = Q.poll();
            int a = tp / C;
            int b = tp % C;

            // left
            int x = left[a][b] / C;
            int y = left[a][b] % C;
            int key = x * C + y;
            if (!inQ.contains(key)) {
                inQ.add(key);
                Q.add(key);
            }

            // right
            x = right[a][b] / C;
            y = right[a][b] % C;
            key = x * C + y;
            if (!inQ.contains(key)) {
                inQ.add(key);
                Q.add(key);
            }

            // up
            x = up[a][b] / C;
            y = up[a][b] % C;
            key = x * C + y;
            if (!inQ.contains(key)) {
                inQ.add(key);
                Q.add(key);
            }

            // down
            x = down[a][b] / C;
            y = down[a][b] % C;
            key = x * C + y;
            if (!inQ.contains(key)) {
                inQ.add(key);
                Q.add(key);
            }
        }

        return inQ.contains(destination[0] * C + destination[1]);
    }

    private void print(int[][] grid) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    private int[][] getDown(int[][] maze) {
        int[][] res = new int[R][C];
        for (int j = 0; j < C; j++) {
            int x = -1;
            int y = -1;
            for (int i = R - 1; i >= 0; i--) {
                if (maze[i][j] == 1) {x = -1; y=-1; continue;}

                if (x == -1) {
                    x = i;
                    y = j;
                }

                res[i][j] = x * C + y;
            }
        }

        return res;
    }

    private int[][] getUp(int[][] maze) {
        int[][] res = new int[R][C];
        for (int j = 0; j < C; j++) {
            int x = -1;
            int y = -1;
            for (int i = 0; i < R; i++) {
                if (maze[i][j] == 1) {x = -1; y=-1; continue;}

                if (x == -1) {
                    x = i;
                    y = j;
                }

                res[i][j] = x * C + y;
            }
        }

        return res;
    }

    private int[][] getRight(int[][] maze) {
        int[][] res = new int[R][C];
        for (int i = 0; i < R; i++) {
            int x = -1;
            int y = -1;
            for (int j = C - 1; j >= 0; j--) {
                if (maze[i][j] == 1) {x = -1; y=-1; continue;}

                if (x == -1) {
                    x = i;
                    y = j;
                }

                res[i][j] = x * C + y;
            }
        }

        return res;
    }

    private int[][] getLeft(int[][] maze) {
        int[][] res = new int[R][C];
        for (int i = 0; i < R; i++) {
            int x = -1;
            int y = -1;
            for (int j = 0; j < C; j++) {
                if (maze[i][j] == 1) {x = -1; y=-1; continue;}

                if (x == -1) {
                    x = i;
                    y = j;
                }

                res[i][j] = x * C + y;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 1, 0},
//                {1, 1, 0, 1, 1},
//                {0, 0, 0, 0, 0},
        };

        System.out.println(new P490_TheMaze().hasPath(maze, new int[]{0, 1}, new int[]{0, 3}));
    }

}
