package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P918_MaximumSumCircularSubarray {


    public int maxSubarraySumCircular(int[] A) {

        int n = A.length;

        int total = 0;

        int now = 0;
        int max = Integer.MIN_VALUE;

        int cur = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            total += A[i];

            now += A[i];
            max = Math.max(max, now);
            if (now < 0) now = 0;


            cur += A[i];
            min = Math.min(min, cur);

            if (cur > 0) cur = 0;
        }

        return max > 0 ? Math.max(max, total - min) : max;
    }

    public static void main(String[] args) {
        System.out.println(new P918_MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{-2, -1, -3}));
        System.out.println(new P918_MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{5, 1, -6, 5}));
        System.out.println(new P918_MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{3, 1, 3, 2, 6}));

    }

}
