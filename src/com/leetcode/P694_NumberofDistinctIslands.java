package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 08/10/2017.
 */
public class P694_NumberofDistinctIslands {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    Set<List<Integer>> ans;
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        ans = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    work(grid, i, j);
                }
            }
        }

        return ans.size();
    }

    private void work(int[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Integer> Q = new LinkedList<>();
        Set<Integer> inQ = new HashSet<>();

        Q.add(x * n + y);
        inQ.add(x * n + y);

        while (!Q.isEmpty()) {
            int tp = Q.poll();

            int nx = tp / n;
            int ny = tp % n;
            grid[nx][ny] = 0;

            for (int i = 0; i < dx.length; i++) {
                int tx = nx + dx[i];
                int ty = ny + dy[i];

                if (tx < 0 || tx >= m || ty < 0 || ty >= n || grid[tx][ty] != 1) continue;

                int key = tx * n + ty;
                if (!inQ.contains(key)) {
                    inQ.add(key);
                    Q.add(key);
                }
            }
        }

        List<Integer> island = new ArrayList<>(inQ);

        island.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int ax = o1 / n;
                int ay = o1 % n;

                int bx = o2 / n;
                int by = o2 % n;

                if (ax == bx) return ay - by;
                return ax - bx;
            }
        });


        int baseX = Integer.MAX_VALUE;
        int baseY = Integer.MAX_VALUE;

        for (int i = 0; i < island.size(); i++) {
            int now = island.get(i);
            int nx = now / n;
            int ny = now % n;


            baseX = Math.min(baseX, nx);
            baseY = Math.min(baseY, ny);
        }

        for (int i = 0; i < island.size(); i++) {
            int now = island.get(i);
            int nx = now / n;
            int ny = now % n;


            nx -= baseX;
            ny -= baseY;
            island.set(i, nx * n + ny);
        }

        ans.add(island);

    }

    public static void main(String[] args) {

        System.out.println(new P694_NumberofDistinctIslands().numDistinctIslands(new int[][]{
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1},
        }));
    }
}
