package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P1030_MatrixCellsinDistanceOrder {


    /**
     * sort
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        List<int[]> data = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                data.add(new int[]{i, j, Math.abs(r0 - i) + Math.abs(c0 - j)});
            }
        }

        data.sort((a, b) -> (a[2] - b[2]));

        int[][] ans = new int[R * C][2];
        int cnt = 0;
        for (int[] p : data) {
            ans[cnt] = new int[]{p[0], p[1]};
            cnt++;
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
