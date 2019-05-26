package com.leetcode;

public class P1053_PreviousPermutationWithOneSwap {


    /**
     * similar to Next Permutation
     *
     * @param A
     * @return
     */
    public int[] prevPermOpt1(int[] A) {

        int j = -1;
        for (int i = 0; i + 1 < A.length; i++) {
            if (A[i] > A[i + 1]) j = i;
        }

        if (j == -1) return A;

        int now = Integer.MIN_VALUE;
        int k = -1;
        for (int i = j + 1; i < A.length; i ++) {
            if (A[i] < A[j] && A[i] >= now) {
                now = A[i];
                k = i;
            }
        }

        int tmp = A[j];
        A[j] = A[k];
        A[k] = tmp;

        return A;
    }


    public static void main(String[] args) {

    }

}
