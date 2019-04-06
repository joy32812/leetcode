package com.leetcode;

public class P977_SquaresofaSortedArray {

    /**
     * easy find the position of min(squares)
     * then compare add
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {

        int nowVal = Integer.MAX_VALUE;
        int pos = -1;
        for (int i = 0; i < A.length; i++) {
            if (nowVal > A[i] * A[i]) {
                nowVal = A[i] * A[i];
                pos = i;
            }
        }

        int i = pos;
        int j = pos + 1;
        int cnt = 0;
        int[] ans = new int[A.length];

        while (cnt < A.length) {
            if (getSq(A, i) < getSq(A, j)) {
                ans[cnt] = getSq(A, i);
                i--;
            } else {
                ans[cnt] = getSq(A, j);
                j++;
            }

            cnt++;
        }

        return ans;
    }

    private int getSq(int[] A, int p) {
        if (p < 0 || p >= A.length) return Integer.MAX_VALUE;
        return A[p] * A[p];
    }

}
