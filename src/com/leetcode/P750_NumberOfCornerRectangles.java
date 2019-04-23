package com.leetcode;

public class P750_NumberOfCornerRectangles {


    /**
     * count edges
     * @param grid
     * @return
     */
    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int ans = 0;

        int m = grid.length;
        int n = grid[0].length;


        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                int cnt = 0;

                for (int i = 0; i < m; i++) {
                    if (grid[i][j] == 1 && grid[i][k] == 1) cnt ++;
                }

                ans = cnt * (cnt - 1) / 2;
            }
        }


        return ans;
    }


    public static void main(String[] args) {

        System.out.println(new P750_NumberOfCornerRectangles().countCornerRectangles(new int[][]{
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1}
        }));

        System.out.println(new P750_NumberOfCornerRectangles().countCornerRectangles(new int[][]{
                {1, 1, 1, 1},
        }));

        System.out.println(new P750_NumberOfCornerRectangles().countCornerRectangles(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        }));
    }

}
