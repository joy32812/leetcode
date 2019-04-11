package com.leetcode;

import java.util.Arrays;

public class P908_SmallestRangeI {

    /**
     * easy find max and min, compare the difference with 2K
     * @param A
     * @param K
     * @return
     */
    public int smallestRangeI(int[] A, int K) {

        int max = Arrays.stream(A).max().getAsInt();
        int min = Arrays.stream(A).min().getAsInt();


        if (max - min <= 2 * K) return 0;

        return max - min - 2 * K;
    }

}
