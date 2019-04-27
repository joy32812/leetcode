package com.leetcode;

public class P845_LongestMountaininArray {

    public int longestMountain(int[] A) {
        if (A == null || A.length < 3)  return 0;
        int n = A.length;

        int ans = 0;
        int begin = 0;
        for (int i = 1; i < n; i++) {
            if (A[i] == A[i - 1]) {
                ans = Math.max(ans, solve(A, begin, i - 1));
                begin = i;
            }
        }

        ans = Math.max(ans, solve(A, begin, A.length - 1));

        return ans;
    }

    private int solve(int[] a, int l, int r) {
        if (r - l + 1 < 3) return 0;

        int[] left = new int[a.length];
        int[] right = new int[a.length];
        for (int i = l; i <= r; i++) left[i] = right[i] = i;

        for (int i = l + 1; i <= r; i++) {
            if (a[i] > a[i - 1]) left[i] = left[i - 1];
        }
        for (int i = r - 1; i >= l; i--) {
            if (a[i] > a[i + 1]) right[i] = right[i + 1];
        }

        int result = 0;
        for (int i = l + 1; i < r; i++) {
            if (a[i] > a[i - 1] && a[i] > a[i + 1]) result = Math.max(result, right[i] - left[i] + 1);
        }

        return result;
    }

}
