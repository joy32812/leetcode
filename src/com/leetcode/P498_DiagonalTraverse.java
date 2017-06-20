package com.leetcode;

/**
 * Created by xiaoyuan on 20/06/2017.
 */
public class P498_DiagonalTraverse {

    int[] dx = {-1, 1};
    int[] dy = {1, -1};
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {return new int[]{};}

        int m = matrix.length;
        int n = matrix[0].length;
        int N = m * n;
        int[] ans = new int[N];


        int x = 0;
        int y = 0;
        int dir = 0;
        int cnt = 0;
        while (true) {
            ans[cnt++] = matrix[x][y];
            if (cnt == N) {break;}

            int tx = x + dx[dir];
            int ty = y + dy[dir];

            if (tx < 0 || tx >=m || ty < 0 || ty >= n) {
                dir = 1 - dir;
                ty ++;
            }

            x = tx;
            y = ty;
            while (x < 0 || x >= m || y < 0 || y >= n) {
                x += dx[dir];
                y += dy[dir];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P498_DiagonalTraverse().findDiagonalOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
    }

}
