package com.leetcode;

/**
 * Created by xiaoyuan on 19/05/2017.
 */
public class P378_KthSmallestElementinaSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;

        int lx = 0, ly = 0;
        int rx = m, ry = n;
        while (true) {

            if ((lx == rx || lx + 1 == rx) && (ly == ry | ly + 1 == ry)) {

            }

            int mx = (lx + rx) / 2;
            int my = (ly + ry) / 2;

            int num = (mx + 1) * (my + 1);
            if (num <= k) {
                lx = mx;
                ly = my;
            } else {
                rx = mx;
                ry = my;
            }
        }

    }

}
