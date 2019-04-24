package com.leetcode;

/**
 * Created by xiaoyuan on 27/02/2017.
 */
public class P48_RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int n = matrix.length;

        // flip horizontally
        for (int i = 0; i < n; i++) {
            for (int j = 0, k = n - 1; j < k; j++, k--) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = tmp;
            }
        }

        // flip by diag
        for (int i = 0; i < n; i++) {
            for (int j = 0; i + j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        new P48_RotateImage().rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
