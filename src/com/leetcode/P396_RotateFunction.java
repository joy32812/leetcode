package com.leetcode;

/**
 * Created by xiaoyuan on 26/05/2017.
 */
public class P396_RotateFunction {

    public int maxRotateFunction(int[] A) {

        int n = A.length;
        int sum = 0;
        int F = 0;
        for (int i = 0; i < n; i++) {
            F += i * A[i];
            sum += A[i];
        }

        int max = F;
        for (int i = n - 1; i >= 1; i--) {
            F = F + sum - n * A[i];
            max = Math.max(max, F);
        }

        return max;
    }

}
