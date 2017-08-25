package com.leetcode;

/**
 * Created by xiaoyuan on 25/08/2017.
 */
public class P363_MaxSumofRectangleNoLargerThanK {

    public int maxSumSubmatrix(int[][] matrix, int k) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] sums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sums[i][j] = matrix[i][j] + getSum(sums, i - 1, j) + getSum(sums, i, j - 1) - getSum(sums, i - 1, j - 1);
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int x = i; x < m; x++) {
                    for (int y = j; y < n; y++) {
                        int val = getSum(sums, x, y) - getSum(sums, i - 1, y) - getSum(sums, x, j - 1) + getSum(sums, i - 1, j - 1);
                        if (val <= k) {
                            ans = Math.max(ans, val);
                        }
                    }
                }
            }
        }

        return ans;
    }

    private int getSum(int[][] sums, int x, int y) {
        if (x < 0 || y < 0) {return 0;}
        return sums[x][y];
    }

    public static void main(String[] args) {
        System.out.println(new P363_MaxSumofRectangleNoLargerThanK().maxSumSubmatrix(new int[][]{
                {1, 0, 1},
                {0, -2, 3},
        }, 2));
    }

}
