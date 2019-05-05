package com.leetcode;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class P1040_MovingStonesUntilConsecutiveII {


    public int[] numMovesStonesII(int[] A) {
        // sort
        int n = A.length;
        Arrays.sort(A);

        int high = Math.max(A[n - 1] - A[1] + 1 - (n - 1), A[n - 2] - A[0] + 1 - (n - 1));

        int i = 0;
        int low = n;
        for (int j = 0; j < n; j ++) {
            while (A[j] - A[i] >= n) i++;
            if (j - i + 1 == n - 1 && A[j] - A[i] + 1 == n - 1) {
                low = Math.min(low, 2);
            } else {
                low = Math.min(low, n - (j - i + 1));
            }
        }

        return new int[]{low, high};
    }

}
