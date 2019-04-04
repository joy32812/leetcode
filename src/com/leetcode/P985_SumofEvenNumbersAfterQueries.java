package com.leetcode;

import java.util.Arrays;

public class P985_SumofEvenNumbersAfterQueries {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {

        int total = 0;
        for (int d : A) {
            if (d % 2 == 0) total += d;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];

            int oldVal = A[q[1]];
            int newVal = A[q[1]] + q[0];

            if (oldVal % 2 == 0) total -= oldVal;
            if (newVal % 2 == 0) total += newVal;

            A[q[1]] = newVal;

            ans[i] = total;
        }

        return ans;
    }

}
