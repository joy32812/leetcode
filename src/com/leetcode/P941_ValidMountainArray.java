package com.leetcode;

public class P941_ValidMountainArray {


    /**
     * an easy and more elegant way
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {

        int N = A.length;
        int i = 0;

        while (i + 1 < N && A[i] < A[i + 1]) i++;
        if (i == 0 || i == N -1) return false;

        while (i + 1 < N && A[i] > A[i + 1]) i++;

        return i == N - 1;
    }

    public boolean validMountainArray2(int[] A) {
        if (A == null || A.length < 3) return false;
        int len = A.length;

        if (A[0] >= A[1]) return false;
        if (A[len - 2] <= A[len - 1]) return false;

        int pos = -1;
        for (int i = 1; i < len; i++) {
            if (A[i] == A[i - 1]) return false;
            if (A[i] < A[i - 1]) {
                pos = i;
                break;
            }
        }
        if (pos == -1) return false;

        for (int i = pos + 1; i < len; i++) {
            if (A[i] >= A[i - 1]) return false;
        }

        return true;
    }



    public static void main(String[] args) {
        System.out.println(new P941_ValidMountainArray().validMountainArray(new int[]{3, 7, 6, 4, 3, 0, 1, 0}));
    }

}
