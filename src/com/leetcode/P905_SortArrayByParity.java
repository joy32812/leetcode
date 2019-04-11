package com.leetcode;

public class P905_SortArrayByParity {


    public int[] sortArrayByParity(int[] A) {

        int i = 0;
        int j = A.length - 1;

        while (i < j) {
            while (i < j && A[i] % 2 == 0) i++;
            while (j > i && A[j] % 2 == 1) j--;

            swap(A, i, j);
        }

        return A;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
    }

}
