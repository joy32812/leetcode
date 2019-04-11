package com.leetcode;

public class P915_PartitionArrayintoDisjointIntervals {

    public int partitionDisjoint(int[] A) {

        int n = A.length;

        int[] leftMax = new int[n];
        int[] rightMin = new int[n];


        int now = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            leftMax[i] = now;
            now = Math.max(now, A[i]);
        }


        now = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            rightMin[i] = now;
            now = Math.min(now, A[i]);
        }

        for (int i = 0; i < n; i++) {
            if (leftMax[i] <= rightMin[i] && A[i] <= rightMin[i]) return i + 1;
        }

        return n;
    }

}
