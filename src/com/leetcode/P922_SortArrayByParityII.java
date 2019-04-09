package com.leetcode;

import java.sql.SQLOutput;

public class P922_SortArrayByParityII {


    public int[] sortArrayByParityII(int[] A) {

        int p = 0;
        int q = 0;

        while (q < A.length) {
            if (p % 2 == A[q] % 2) {
                swap(A, p, q);
                p ++;
            }
            while (p < q && p % 2 == A[p] % 2) p ++;

            q++;
        }

        return A;
    }

    private void swap(int[] A, int p, int q) {
        int tmp = A[p];
        A[p] = A[q];
        A[q] = tmp;
    }

    public static void main(String[] args) {
        int[] ans = new P922_SortArrayByParityII().sortArrayByParityII(new int[]{4, 2, 6, 7, 9, 3});

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

}
