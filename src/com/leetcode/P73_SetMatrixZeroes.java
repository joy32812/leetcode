package com.leetcode;

/**
 * Created by xiaoyuan on 01/03/2017.
 */
public class P73_SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {return;}

        int n = matrix[0].length;
        if (n == 0) {return;}

        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (rows[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (cols[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {

    }

}
