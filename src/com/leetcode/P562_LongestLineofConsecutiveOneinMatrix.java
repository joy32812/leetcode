package com.leetcode;

/**
 * Created by xiaoyuan on 30/06/2017.
 */
public class P562_LongestLineofConsecutiveOneinMatrix {

    public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {return 0;}

        int ans = getMax(M, 0, 1);
        ans = Math.max(ans, getMax(M, 1, 0));
        ans = Math.max(ans, getMax(M, 1, 1));
        ans = Math.max(ans, getMax(M, -1, 1));

        return ans;
    }

    private int getMax(int[][] M, int dx, int dy) {
        int m = M.length;
        int n = M[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 0) {continue;}
                if (i - dx < m && i - dx >= 0 && j - dy < n && j - dy >= 0 && M[i - dx][j - dy] == 1) {continue;}

                ans = Math.max(ans, getLen(M, i, j, dx, dy));
            }
        }

        return ans;
    }


    private int getLen(int[][] M, int x, int y, int dx, int dy) {

        int m = M.length;
        int n = M[0].length;

        int ans = 1;
        // diagonal
        int len = 1;
        for (int i = x + dx, j = y + dy; i >=0 && i < m && j >= 0 && j < n; i += dx, j += dy) {
            if (M[i][j] == 0) {break;}
            len++;
        }
        ans = Math.max(ans, len);

        return ans;
    }

    public static void main(String[] args) {
        int[][] grid =
        {
                {1,1,0,0,1,0,0,1,1,0},
                {1,0,0,1,0,1,1,1,1,1},
                {1,1,1,0,0,1,1,1,1,0},
                {0,1,1,1,0,1,1,1,1,1},
                {0,0,1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,0,1,1,1},
                {0,1,1,1,1,1,1,0,0,1},
                {1,1,1,1,1,0,0,1,1,1},
                {0,1,0,1,1,0,1,1,1,1},
                {1,1,1,0,1,0,1,1,1,1}
        };

        System.out.println(new P562_LongestLineofConsecutiveOneinMatrix().longestLine(grid));
    }

}
