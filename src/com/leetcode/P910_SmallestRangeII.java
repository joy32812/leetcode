package com.leetcode;

import java.util.Arrays;

public class P910_SmallestRangeII {


    /**
     * sort and check
     * @param A
     * @param K
     * @return
     */
    public int smallestRangeII(int[] A, int K) {

        int n = A.length;
        Arrays.sort(A);
        int ans = A[n - 1] - A[0];

        for (int i = 0; i < A.length - 1; i++) {
            int a = A[0] + K;
            int b = A[i] + K;
            int c = A[i + 1] - K;
            int d = A[n - 1] - K;

            int nowMax = Math.max(b, d);
            int nowMin = Math.min(a, c);

            ans = Math.min(ans, nowMax - nowMin);
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new P910_SmallestRangeII().smallestRangeII(new int[]{3, 1, 10}, 4));
    }

}
