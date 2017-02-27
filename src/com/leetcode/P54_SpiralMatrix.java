package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 27/02/2017.
 * int[] dx = {0, 1, 0, -1};
 * int[] dy = {1, 0, -1, 0};
 * 控制遍历方向即可
 */
public class P54_SpiralMatrix {


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visit = new boolean[m][n];
        int total = m * n;
        int x = 0, y = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int pos = 0;

        while (total > 0) {
            visit[x][y] = true;
            ans.add(matrix[x][y]);

            int mx = x + dx[pos];
            int my = y + dy[pos];
            if (mx < 0 || mx >= m || my < 0 || my >= n || visit[mx][my]) {
                pos = (pos + 1) % 4;
            }

            x = x + dx[pos];
            y = y + dy[pos];

            total--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };




        System.out.println(new P54_SpiralMatrix().spiralOrder(nums));
    }

}
