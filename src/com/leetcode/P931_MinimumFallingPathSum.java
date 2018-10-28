package com.leetcode;

public class P931_MinimumFallingPathSum {


    /**
     * dp
     * like number triangle
     * pretty strait forward
     * @param A
     * @return
     */
    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) return 0;


        int m = A.length;
        int n = A[0].length;


        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {

                int x = A[i][j];

                int z = A[i + 1][j];
                if (j - 1 >= 0) z = Math.min(z, A[i + 1][j - 1]);
                if (j + 1 < n) z = Math.min(z, A[i + 1][j + 1]);

                A[i][j] = x + z;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, A[0][j]);
        }

        return ans;
    }


    public static void main(String[] args) {

        int[][] A = new int[][] {
                {51, 24},
                {-50, 82}
        };

        System.out.println(new P931_MinimumFallingPathSum().minFallingPathSum(A));
    }

}
