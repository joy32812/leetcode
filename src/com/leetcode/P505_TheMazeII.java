package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 24/06/2017.
 */
public class P505_TheMazeII {


    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return -1;


        int m = maze.length;
        int n = maze[0].length;


        Queue<Integer> Q = new LinkedList<>();
        Q.add(start[0] * n + start[1]);

        Set<Integer> inQ = new HashSet<>();
        inQ.add(Q.peek());

        Map<Integer, Integer> disMap = new HashMap<>();
        disMap.put(Q.peek(), 0);


        while (!Q.isEmpty()) {
            int now = Q.poll();
            int x = now / n;
            int y = now % n;

            inQ.remove(now);

            for (int k = 0; k < dx.length; k ++) {

                int tx = x + dx[k];
                int ty = y + dy[k];
                int cnt = 0;

                while (tx >= 0 && tx < m && ty >= 0 && ty < n && maze[tx][ty] == 0) {
                    cnt ++;
                    tx += dx[k];
                    ty += dy[k];
                }

                tx -= dx[k];
                ty -= dy[k];


                int val = tx * n + ty;

                if (disMap.getOrDefault(val, Integer.MAX_VALUE) > disMap.get(now) + cnt) {
                    disMap.put(val, disMap.getOrDefault(now, 0) + cnt);
                    if (!inQ.contains(val)) {
                        inQ.add(val);
                        Q.add(val);
                    }
                }
            }
        }

        int dest = destination[0] * n + destination[1];

        return disMap.getOrDefault(dest, -1);
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
