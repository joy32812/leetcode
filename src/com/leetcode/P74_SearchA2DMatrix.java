package com.leetcode;

/**
 * Created by xiaoyuan on 01/03/2017.
 */
public class P74_SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int lx = 0, ly = 0;
        int rx = matrix.length - 1, ry = matrix[0].length - 1;

        return dfs(matrix, lx, ly, rx, ry, target);
    }

    public boolean dfs(int[][] matrix, int lx, int ly, int rx, int ry, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || lx > rx || ly > ry) {
            return false;
        }

        while (lx < rx || ly < ry) {
            if ((lx == rx || lx + 1 == rx) && (ly == ry || ly + 1 == ry)) {
                break;
            }

            int midx = (lx + rx) / 2;
            int midy = (ly + ry) / 2;

            if(dfs(matrix, lx, midy + 1, midx, ry, target) || dfs(matrix, midx + 1, ly, rx, midy, target)) {
                return true;
            }
            if (matrix[midx][midy] > target) {
                rx = midx;
                ry = midy;
            } else {
                lx = midx;
                ly = midy;
            }
        }

        return matrix[lx][ly] == target || matrix[lx][ry] == target || matrix[rx][ly] == target || matrix[rx][ry] == target;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(new P74_SearchA2DMatrix().searchMatrix(matrix, 50));
    }

}
