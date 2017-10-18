package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 18/10/2017.
 */
public class P711_NumberofDistinctIslandsII {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    private static final int Z = 100;

    Set<List<Integer>> ans;
    public int numDistinctIslands2(int[][] grid) {
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

        Q.add(x * Z + y);
        inQ.add(x * Z + y);

        while (!Q.isEmpty()) {
            int tp = Q.poll();

            int nx = tp / Z;
            int ny = tp % Z;
            grid[nx][ny] = 0;

            for (int i = 0; i < dx.length; i++) {
                int tx = nx + dx[i];
                int ty = ny + dy[i];

                if (tx < 0 || tx >= m || ty < 0 || ty >= n || grid[tx][ty] != 1) continue;

                int key = tx * Z + ty;
                if (!inQ.contains(key)) {
                    inQ.add(key);
                    Q.add(key);
                }
            }
        }

        List<Integer> island = new ArrayList<>(inQ);

        island = upperAndLeft(island);
        ans.add(uniq(island));
    }

    private List<Integer> upperAndLeft(List<Integer> is) {
        List<Integer> island = new ArrayList<>(is);
        island.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int ax = o1 / Z;
                int ay = o1 % Z;

                int bx = o2 / Z;
                int by = o2 % Z;

                if (ax == bx) return ay - by;
                return ax - bx;
            }
        });


        int baseX = Integer.MAX_VALUE;
        int baseY = Integer.MAX_VALUE;

        for (int i = 0; i < island.size(); i++) {
            int now = island.get(i);
            int nx = now / Z;
            int ny = now % Z;


            baseX = Math.min(baseX, nx);
            baseY = Math.min(baseY, ny);
        }

        for (int i = 0; i < island.size(); i++) {
            int now = island.get(i);
            int nx = now / Z;
            int ny = now % Z;


            nx -= baseX;
            ny -= baseY;
            island.set(i, nx * Z + ny);
        }
        return island;
    }


    private List<Integer> uniq(List<Integer> island) {

        List<Integer> rotate90 = rotate(island);
        List<Integer> rotate180 = rotate(rotate90);
        List<Integer> rotate270 = rotate(rotate180);

        List<Integer> ref = reflect(island);
        List<Integer> r90 = rotate(ref);
        List<Integer> r180 = rotate(r90);
        List<Integer> r270 = rotate(r180);

        List<Integer> res = new ArrayList<>(island);
        res = smaller(res, rotate90);
        res = smaller(res, rotate180);
        res = smaller(res, rotate270);
        res = smaller(res, ref);
        res = smaller(res, r90);
        res = smaller(res, r180);
        res = smaller(res, r270);


        return res;
    }

    private List<Integer> smaller(List<Integer> res, List<Integer> other) {
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) < other.get(i)) {
                return res;
            } else if (res.get(i) > other.get(i)) {
                return other;
            }
        }
        return res;
    }

    private List<Integer> reflect(List<Integer> island) {
        List<Integer> res = new ArrayList<>();
        for (int d : island) {

            int nx = d / Z;
            int ny = d % Z;

            int tx = nx;
            int ty = Z - ny - 1;

            res.add(tx * Z + ty);
        }
        return upperAndLeft(res);
    }


    private List<Integer> rotate(List<Integer> island) {

        List<Integer> res = new ArrayList<>();
        for (int d : island) {
            int nx = d / Z;
            int ny = d % Z;

            int tx = ny;
            int ty = Z - 1 - nx;

            res.add(tx * Z + ty);
        }

        return upperAndLeft(res);
    }

}
