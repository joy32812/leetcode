package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaoyuan on 25/04/2017.
 */
public class P305_NumberofIslandsII {

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    int[] father;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();

        Set<Integer> fatherSet = new HashSet<>();
        father = new int[positions.length + 1];

        int[][] grid = new int[m][n];
        int cnt = 0;

        for (int[] pos : positions) {
            int x = pos[0];
            int y = pos[1];

            if (x < 0 || x >= m || y < 0 || y >= n) {ans.add(fatherSet.size());continue;}

            cnt++;
            grid[x][y] = cnt;
            father[cnt] = cnt;
            fatherSet.add(cnt);

            for (int i = 0; i < dx.length; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];

                if (tx < 0 || tx >= m || ty < 0 || ty >= n || grid[tx][ty] == 0) {continue;}

                int fa = getFather(grid[x][y]);
                int fb = getFather(grid[tx][ty]);
                if (fa == fb) {continue;}

                int t = fa > fb ? fa : fb;
                if (fatherSet.contains(t)) {
                    fatherSet.remove(t);
                }
                father[t] = fa > fb ? fb : fa;
            }

            ans.add(fatherSet.size());
        }

        return ans;
    }

    private int getFather(int i) {
        if (father[i] == i) {return i;}
        return getFather(father[i]);
    }

}
