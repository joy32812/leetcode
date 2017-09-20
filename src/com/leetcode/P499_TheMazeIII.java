package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xiaoyuan on 20/09/2017.
 */
public class P499_TheMazeIII {


    int minStep;
    String ans;

    private class Cell {
        int step;
        String path;

        public Cell(int step, String path) {
            this.step = step;
            this.path = path;
        }
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    char[] dir = {'u', 'd', 'l', 'r'};

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;

        Cell[][] grid = new Cell[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = new Cell(Integer.MAX_VALUE, "");
            }
        }


        minStep = Integer.MAX_VALUE;
        ans = "";

        Queue<Integer> Q = new LinkedList<>();
        grid[ball[0]][ball[1]] = new Cell(0, "");
        Q.add(ball[0] * n + ball[1]);

        Set<Integer> inQ = new HashSet<>();
        inQ.add(ball[0] * n + ball[1]);

        // bfs
        while (!Q.isEmpty()) {
            int tp = Q.poll();
            inQ.remove(tp);

            int x = tp / n;
            int y = tp % n;


            for (int k = 0; k < dx.length; k++) {
                int tx = x;
                int ty = y;

                String path = grid[x][y].path;
                int nowStep = grid[x][y].step;

                while (true) {
                    tx += dx[k];
                    ty += dy[k];

                    if (tx < 0 || tx >=m || ty < 0 || ty >= n || maze[tx][ty] == 1) break;
                    nowStep ++;

                    if (tx == hole[0] && ty == hole[1]) {
                        if (minStep > nowStep || (minStep == nowStep && ans.compareTo(path) > 0)) {
                            minStep = nowStep;
                            ans = path + dir[k];
                        }
                    }
                }

                tx -= dx[k];
                ty -= dy[k];

                path = path + dir[k];

                if (grid[tx][ty].step > nowStep || (grid[tx][ty].step == nowStep && grid[tx][ty].path.compareTo(path) > 0)) {
                    grid[tx][ty].step = nowStep;
                    grid[tx][ty].path = path;
                    int key = tx * n + ty;
                    if (!inQ.contains(key)) {
                        Q.add(key);
                    }
                }

            }

        }


        return minStep == Integer.MAX_VALUE ? "impossible" : ans;
    }

    public static void main(String[] args) {
        System.out.println(new P499_TheMazeIII().findShortestWay(new int[][]{
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0}
        }, new int[]{4, 3}, new int[]{0, 1}));
        System.out.println(new P499_TheMazeIII().findShortestWay(new int[][]{
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0}
        }, new int[]{4, 3}, new int[]{3, 0}));
    }

}
