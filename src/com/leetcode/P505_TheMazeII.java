package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xiaoyuan on 24/06/2017.
 */
public class P505_TheMazeII {

    int[][] leftWalls;
    int[][] rightWalls;
    int[][] upWalls;
    int[][] downWalls;
    int[][] res;
    int m, n;
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        m = maze.length;
        n = maze[0].length;

        leftWalls = new int[m][n];
        rightWalls = new int[m][n];
        upWalls = new int[m][n];
        downWalls = new int[m][n];
        res = new int[m][n];

        getLeftWalls(maze);
        getRightWalls(maze);
        getUpWalls(maze);
        getDownWalls(maze);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = Integer.MAX_VALUE;
            }
        }
        res[start[0]][start[1]] = 0;

        bfs(maze, start[0], start[1]);

        return res[destination[0]][destination[1]] != Integer.MAX_VALUE ? res[destination[0]][destination[1]] : -1;
    }

    private void bfs(int[][] maze, int x, int y) {

        Queue<Integer> Q = new LinkedList<>();
        Set<Integer> inQ = new HashSet<>();

        Q.add(x * n + y);
        inQ.add(x * n + y);


        while (!Q.isEmpty()) {
            int tp = Q.poll();
            inQ.remove(tp);

            int nx = tp / n;
            int ny = tp % n;

            int tx = nx;
            int ty = ny;
            //left
            tx = nx;
            ty = leftWalls[nx][ny] + 1;

            int len = Math.abs(ty - ny);
            if (tx >= 0 && tx < m && ty >= 0 && ty < n && res[tx][ty] > res[nx][ny] + len) {
                res[tx][ty] = res[nx][ny] + len;

                int key = tx * n + ty;
                if (!inQ.contains(key)) {
                    Q.add(key);
                    inQ.add(key);
                }
            }


            //right
            tx = nx;
            ty = rightWalls[nx][ny] - 1;
            len = Math.abs(ty - ny);
            if (tx >= 0 && tx < m && ty >= 0 && ty < n && res[tx][ty] > res[nx][ny] + len) {
                res[tx][ty] = res[nx][ny] + len;

                int key = tx * n + ty;
                if (!inQ.contains(key)) {
                    Q.add(key);
                    inQ.add(key);
                }
            }


            //up
            ty = ny;
            tx = upWalls[nx][ny] + 1;
            len = Math.abs(tx - nx);
            if (tx >= 0 && tx < m && ty >= 0 && ty < n && res[tx][ty] > res[nx][ny] + len) {
                res[tx][ty] = res[nx][ny] + len;

                int key = tx * n + ty;
                if (!inQ.contains(key)) {
                    Q.add(key);
                    inQ.add(key);
                }
            }

            //down
            ty = ny;
            tx = downWalls[nx][ny] - 1;
            len = Math.abs(tx - nx);
            if (tx >= 0 && tx < m && ty >= 0 && ty < n && res[tx][ty] > res[nx][ny] + len) {
                res[tx][ty] = res[nx][ny] + len;

                int key = tx * n + ty;
                if (!inQ.contains(key)) {
                    Q.add(key);
                    inQ.add(key);
                }
            }

        }

    }

    private void getDownWalls(int[][] maze) {
        for (int j = 0; j < n; j++) {
            int wall = m;

            for (int i = m - 1; i >= 0; i--) {
                if (maze[i][j] == 1) {
                    wall = i;
                } else {
                    downWalls[i][j] = wall;
                }
            }

        }
    }

    private void getUpWalls(int[][] maze) {
        for (int j = 0; j < n; j++) {
            int wall = -1;

            for (int i = 0; i < m; i++) {
                if (maze[i][j] == 1) {
                    wall = i;
                } else {
                    upWalls[i][j] = wall;
                }
            }

        }
    }

    private void getRightWalls(int[][] maze) {
        for (int i = 0; i < m; i++) {
            int wall = n;
            for (int j = n - 1; j >= 0; j--) {
                if (maze[i][j] == 1) {
                    wall = j;
                } else {
                    rightWalls[i][j] = wall;
                }
            }
        }
    }

    private void getLeftWalls(int[][] maze) {
        for (int i = 0; i < m; i++) {
            int wall = -1;
            for (int j = 0; j < n; j++) {
                if (maze[i][j] == 1) {
                    wall = j;
                } else {
                    leftWalls[i][j] = wall;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new P505_TheMazeII().shortestDistance(new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0},
        }, new int[]{0, 4}, new int[]{4, 4}));
    }

}
