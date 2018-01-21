package com.leetcode;

public class B1 {


    public boolean isToeplitzMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {

            int x = i;
            int y = 0;
            int v = matrix[x][y];
            while (x < m && y < n) {
                if (matrix[x][y] != v) return false;

                x++;
                y++;
            }
        }

        for (int j = 0; j < n; j++) {

            int x = 0;
            int y = j;
            int v = matrix[x][y];
            while (x < m && y < n) {
                if (matrix[x][y] != v) return false;

                x++;
                y++;
            }
        }

        return true;
    }

    public static void main(String[] args) {



    }

}
