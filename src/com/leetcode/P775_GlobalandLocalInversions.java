package com.leetcode;

import java.util.PriorityQueue;

public class P775_GlobalandLocalInversions {

    public boolean isIdealPermutation(int[] A) {

        int max = A[0];
        for (int i = 2; i < A.length; i++) {
            if (max > A[i]) return false;
            max = Math.max(max, A[i - 1]);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P775_GlobalandLocalInversions().isIdealPermutation(new int[]{1, 2, 0}));
    }

}
