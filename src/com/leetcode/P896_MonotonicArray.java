package com.leetcode;

public class P896_MonotonicArray {

    public boolean isMonotonic(int[] A) {

        return incr(A) || desc(A);

    }

    private boolean incr(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) return  false;
        }
        return true;
    }

    private boolean desc(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) return  false;
        }
        return true;
    }

}
