package com.leetcode;

public class P832_FlippinganImage {

    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0) return A;

        int n = A.length;

        // flip horizontally
        for (int i = 0; i < n; i++) {
            for (int j = 0, k = n - 1; j < k; j++, k--) {
                int tmp = A[i][j];
                A[i][j] = A[i][k];
                A[i][k] = tmp;
            }
        }

        // invert
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = 1 - A[i][j];
            }
        }

        return A;
    }

}
