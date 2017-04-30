package com.leetcode;

/**
 * Created by xiaoyuan on 30/04/2017.
 */
public class P311_SparseMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {

        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;

        int[][] result = new int[m][p];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) {continue;}
                for (int k = 0; k < p; k++) {
                    result[i][k] += (A[i][j] * B[j][k]);
                }
            }
        }

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < p; j++) {
//
//                int val = 0;
//                for (int k = 0; k < n; k++) {
//                    val += (A[i][k] * B[k][j]);
//                }
//
//                result[i][j] = val;
//            }
//        }

        return result;
    }


}
