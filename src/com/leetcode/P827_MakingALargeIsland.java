package com.leetcode;

import java.util.*;

public class P827_MakingALargeIsland {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    /**
     * medium
     * union find
     * @param grid
     * @return
     */
    public int largestIsland(int[][] grid) {

        int n = grid.length;
        int[] father = new int[n * n + 1];
        Arrays.fill(father, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;


                int s = i * n + j;
                for (int k = 0; k < dx.length; k++) {
                    int tx = i + dx[k];
                    int ty = j + dy[k];

                    if (tx < 0 || tx >= n || ty < 0 || ty >= n || grid[tx][ty] == 0) continue;
                    int t = tx * n + ty;

                    int fs = getFather(s, father);
                    int ft = getFather(t, father);

                    if (fs != ft) father[fs] = ft;
                }
            }
        }


        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;

                int now = i * n + j;
                int fa = getFather(now, father);

                cntMap.put(fa, cntMap.getOrDefault(fa, 0) + 1);
            }
        }

        int ans = 0;
        for (int num: cntMap.values()) ans = Math.max(ans, num);

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;

                Set<Integer> faSet = new HashSet<>();

                for (int k = 0; k < dx.length; k++) {
                    int tx = i + dx[k];
                    int ty = j + dy[k];

                    if (tx < 0 || tx >= n || ty < 0 || ty >=n || grid[tx][ty] == 0) continue;
                    int t = tx * n + ty;

                    int ft = getFather(t, father);
                    faSet.add(ft);
                }


                int total = 1;
                for (int d : faSet) {
                    total += cntMap.get(d);
                }

                ans = Math.max(ans, total);
            }
        }

        return ans;
    }

    private int getFather(int s, int[] father) {
        if (father[s] == -1) father[s] = s;

        int now = s;
        while (now != father[now]) {
            now = father[now];
        }

        return father[s] = now;
    }

}
