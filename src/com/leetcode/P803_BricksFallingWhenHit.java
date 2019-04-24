package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class P803_BricksFallingWhenHit {

    int[] size;
    int[] father;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    /**
     * union find
     * @param grid
     * @param hits
     * @return
     */
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;

        for (int[] h : hits) {
            if (grid[h[0]][h[1]] == 1) grid[h[0]][h[1]] = 2;
        }


        father = new int[m * n + 1];
        size = new int[m * n + 1];
        for (int i = 0; i < father.length; i++) father[i] = i;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) size[i * n + j] = 1;
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;

                if (i == 0) union(i * n + j, m * n);
                if (j + 1 < n && grid[i][j + 1] == 1) union(i * n + j, i * n + (j + 1));
                if (i + 1 < m && grid[i + 1][j] == 1) union(i * n + j, (i + 1) * n + j);
            }
        }


        int[] ans = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int[] hit = hits[i];
            int x = hit[0];
            int y = hit[1];
            if (grid[x][y] == 0) continue;
            grid[x][y] = 1;

            Set<Integer> faSet = new HashSet<>();
            for (int k = 0; k < dx.length; k++) {
                int tx = x + dx[k];
                int ty = y + dy[k];
                if (tx < 0) {
                    faSet.add(m * n);
                }
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || grid[tx][ty] != 1) continue;
                faSet.add(find(tx * n + ty));
            }


            if (faSet.contains(m * n)) {
                int total = 0;
                for (int fa : faSet) {
                    if (fa != m * n) total += size[fa];
                }
                ans[i] = total;
            }

            for (int fa : faSet) union(x * n + y, fa);

            size[find(x * n + y)] ++;
        }

        return ans;
    }

    private void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx < fy) {
            father[fx] = fy;
            size[fy] += size[fx];
        } else {
            father[fy] = fx;
            size[fx] += size[fy];
        }
    }

    private int find(int x) {
        if (father[x] != x) return father[x] = find(father[x]);
        return father[x];
    }

    public static void main(String[] args) {
        System.out.println(new P803_BricksFallingWhenHit().hitBricks(new int[][]{
                {1,0,1},{1,1,1}
        }, new int[][]{
                {0,0},{0,2},{1,1}
        }));
//        System.out.println(new P803_BricksFallingWhenHit().hitBricks(new int[][]{
//                {1},{1},{1},{1},{1}
//        }, new int[][]{
//                {3,0},{4,0},{1,0},{2,0},{0,0}
//        }));
//        System.out.println(new P803_BricksFallingWhenHit().hitBricks(new int[][]{
//                {1, 0, 0, 0},
//                {1, 1, 0, 0}
//        }, new int[][]{
//                {1, 1},
//                {1, 0}
//        }));
//        System.out.println(new P803_BricksFallingWhenHit().hitBricks(new int[][]{
//                {1, 0, 0, 0},
//                {1, 1, 1, 0}
//        }, new int[][]{
//                {1, 0}
//        }));
    }

}
