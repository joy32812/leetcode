package com.leetcode;

/**
 * Created by xiaoyuan on 02/05/2017.
 */
public class P308_RangeSumQuery2DMutable {

    private int[][] tree;
    int[][] nums;
    int m;
    int n;

    public P308_RangeSumQuery2DMutable(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;

        m = matrix.length;
        n = matrix[0].length;
        tree = new int[m + 1][n + 1];
        nums = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int delta = val - nums[row][col];
        nums[row][col] = val;

        for (int i = row + 1; i <= m; i += i & (-i)) {
            for (int j = col + 1; j <= n; j += j & (-j)) {
                tree[i][j] += delta;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2 + 1, col2 + 1) + sum(row1, col1) - sum(row1, col2 + 1) - sum(row2 + 1, col1);
    }

    public int sum (int row, int col) {
        int sum = 0;
        for (int i = row; i > 0; i -= i & (-i)) {
            for (int j = col; j > 0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        P308_RangeSumQuery2DMutable obj = new P308_RangeSumQuery2DMutable(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });

        System.out.println(obj.sumRegion(2, 1, 4, 3));
        obj.update(3, 2, 2);
        System.out.println(obj.sumRegion(2, 1, 4, 3));

    }

}
