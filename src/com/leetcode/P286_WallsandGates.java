package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xiaoyuan on 20/04/2017.
 */
public class P286_WallsandGates {

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) {return;}

        int n = rooms.length;
        int m = rooms[0].length;

        Queue<Integer> Q = new LinkedList<>();
        Set<Integer> inQ = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    Q.add(i * m + j);
                    inQ.add(i * m + j);
                }
            }
        }

        while (!Q.isEmpty()) {
            int top = Q.poll();
            int x = top / m;
            int y = top % m;

            for (int i = 0; i < dx.length; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];

                int v = tx * m + ty;
                if (tx >= 0 && tx < n && ty >= 0 && ty < m && rooms[tx][ty] != -1 && rooms[tx][ty] != 0 && rooms[tx][ty] > rooms[x][y] + 1) {
                    rooms[tx][ty] = rooms[x][y] + 1;
                    if (!inQ.contains(v)) {
                        Q.add(v);
                        inQ.add(v);
                    }
                }
            }
        }
    }

}
