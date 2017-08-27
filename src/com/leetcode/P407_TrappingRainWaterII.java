package com.leetcode;

import java.util.PriorityQueue;

/**
 * Created by xiaoyuan on 27/08/2017.
 */
public class P407_TrappingRainWaterII {

    private class Cell {
        int row;
        int col;
        int height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {return 0;}
        int m = heightMap.length;
        int n = heightMap[0].length;
        if (m <= 2 && n <= 2) {return 0;}

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> {return a.height - b.height;});

        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pq.add(new Cell(i, 0, heightMap[i][0]));
            visit[i][0] = true;

            pq.add(new Cell(i, n - 1, heightMap[i][n - 1]));
            visit[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            pq.add(new Cell(0, j, heightMap[0][j]));
            visit[0][j] = true;

            pq.add(new Cell(m - 1, j, heightMap[m - 1][j]));
            visit[m - 1][j] = true;
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();

            for (int i = 0; i < dx.length; i++) {
                int row = cell.row + dx[i];
                int col  =cell.col + dy[i];

                if (row >= 0 && row < m && col >= 0 && col < n && !visit[row][col]) {
                    visit[row][col] = true;
                    if (cell.height > heightMap[row][col]) ans += cell.height - heightMap[row][col];

                    pq.add(new Cell(row, col, Math.max(cell.height, heightMap[row][col])));
                }
            }

        }

        return ans;
    }

}
