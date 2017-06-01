package com.leetcode;

/**
 * Created by xiaoyuan on 01/06/2017.
 */
public class P413_ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {return 0;}

        int[] diff = new int[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            diff[i - 1] = A[i] - A[i - 1];
        }

        int ans = 0;
        int from = 0;
        for (int i = 1; i <= diff.length; i++) {
            if (i == diff.length || diff[i] != diff[i - 1]) {
                int n = i - from;
                ans += n * (n - 1) / 2;

                from = i;
            }
        }

        return ans;
    }

}
