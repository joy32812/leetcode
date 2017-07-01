package com.leetcode;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P566_ReshapetheMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {return nums;}
        if (1l * nums.length * nums[0].length != 1l * r * c) {return nums;}

        int[][] ans = new int[r][c];


        int x = 0;
        int y = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                ans[x][y] = nums[i][j];

                if (y + 1 == c) {
                    x ++;
                    y = 0;
                } else {
                    y++;
                }
            }
        }

        return ans;
    }

}
