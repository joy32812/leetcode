package com.leetcode;

public class P795_NumberofSubarrayswithBoundedMaximum {

    int LL;
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        if (A == null || A.length == 0) return 0;

        LL = L;

        int ans = 0;

        int left = 0;
        for (int i = 0; i <= A.length; i++) {
            if (i == A.length || A[i] > R) {
                ans += getNumber(A, left, i - 1);
                left = i + 1;
            }
        }

        return ans;
    }

    private int getNumber(int[] a, int l, int r) {
        if (l > r) return 0;

        int result = 0;
        for (int i = l; i <= r; i++) {
            if (a[i] >= LL) {
                int x = i - l + 1;
                int y = r - i + 1;

                result += x * y;
                l = i + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P795_NumberofSubarrayswithBoundedMaximum().numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
    }

}
