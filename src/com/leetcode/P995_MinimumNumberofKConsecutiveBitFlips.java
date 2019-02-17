package com.leetcode;

public class P995_MinimumNumberofKConsecutiveBitFlips {

    /**
     * greedy
     * @param A
     * @param K
     * @return
     */
    public int minKBitFlips(int[] A, int K) {

        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) continue;

            if (i + K > A.length) break;

            cnt ++;
            for (int j = i; j < i + K; j++) {
                A[j] = 1 - A[j];
            }
        }

        for (int v : A) {
            if (v == 0) return -1;
        }

        return cnt;
    }

    public static void main(String[] args) {

        System.out.println(new P995_MinimumNumberofKConsecutiveBitFlips().minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3));

    }

}
