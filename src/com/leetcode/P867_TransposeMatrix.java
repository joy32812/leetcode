package com.leetcode;

public class P867_TransposeMatrix {

    public int[][] transpose(int[][] A) {
        if (A == null || A.length == 0) return new int[][]{};

        int m = A.length;
        int n = A[0].length;

        int[][] ans = new int[n][m];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = A[i][j];
            }
        }

        return ans;
    }

}
