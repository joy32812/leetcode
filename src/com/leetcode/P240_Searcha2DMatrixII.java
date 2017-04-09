package com.leetcode;

/**
 * Created by xiaoyuan on 09/04/2017.
 */
public class P240_Searcha2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {return false;}

        return find(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
    }

    private boolean find(int[][] matrix, int sx, int sy, int ex, int ey, int target) {
        if (
                (sx < 0 || sx >= matrix.length) ||
                        (ex < 0 || ex >= matrix.length) ||
                        (sy < 0 || sy >= matrix[0].length) ||
                        (ey < 0 || ey >= matrix[0].length) ||
                        sx > ex || sy > ey
                ) {return false;}

        int mx = (sx + ex) / 2;
        int my = (sy + ey) / 2;

        if (matrix[mx][my] == target) {return true;}

        if (matrix[mx][my] < target) {
            return find(matrix, sx, my + 1, mx, ey, target) || find(matrix, mx + 1, sy, ex, my, target) || find(matrix, mx + 1, my + 1, ex, ey, target);
        } else {
            return find(matrix, sx, my, mx - 1, ey, target) || find(matrix, mx, sy, ex, my - 1, target) || find(matrix, sx, sy, mx - 1, my - 1, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(new P240_Searcha2DMatrixII().searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 5));
    }

}
