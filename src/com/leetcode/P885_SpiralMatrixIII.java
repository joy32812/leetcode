package com.leetcode;

public class P885_SpiralMatrixIII {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {


        int[][] ans = new int[R * C][2];


        int ind = 0;
        ans[ind++] = new int[]{r0, c0};

        int minX = r0 - 1;
        int maxX = r0 + 1;
        int minY = c0 - 1;
        int maxY = c0 + 1;

        while (ind < R * C) {
            int tx = minX + 1;
            int ty = maxY;
            if (tx >= 0 && tx < R && ty >= 0 && ty < C) ans[ind++] = new int[]{tx, ty};

            int k = 0;
            while (k < dx.length) {
                tx += dx[k];
                ty += dy[k];

                if (tx < minX || tx > maxX || ty < minY || ty > maxY) {
                    tx -= dx[k];
                    ty -= dy[k];

                    k++;
                    continue;
                }

                if (tx >= 0 && tx < R && ty >= 0 && ty < C) ans[ind++] = new int[]{tx, ty};
            }

            minX --;
            maxX ++;
            minY --;
            maxY ++;
        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P885_SpiralMatrixIII().spiralMatrixIII(1, 4, 0, 0));
    }

}
