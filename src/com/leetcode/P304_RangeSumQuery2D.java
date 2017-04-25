package com.leetcode;

/**
 * Created by xiaoyuan on 25/04/2017.
 */
public class P304_RangeSumQuery2D {

    private int[][] total;
    public P304_RangeSumQuery2D(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {return;}
        int n = matrix[0].length;

        total = new int[m][n];
        for (int i = 0; i < m; i++) {
            int lineSum = 0;
            for (int j = 0; j < n; j++) {
                lineSum += matrix[i][j];
                total[i][j] = (i - 1 >= 0 ? total[i - 1][j] : 0) + lineSum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) - getSum(row1 - 1, col2) - getSum(row2, col1 - 1) + getSum(row1 - 1, col1 - 1);
    }

    private int getSum(int r, int c) {
        if (r < 0 || c < 0) {return 0;}
        return total[r][c];
    }

}
