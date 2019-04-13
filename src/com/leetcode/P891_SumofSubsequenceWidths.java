package com.leetcode;

import java.util.Arrays;

public class P891_SumofSubsequenceWidths {

    /**
     * hard
     * sort the array
     * for every i
     * there are 2^i : A[i] will be the smallest one
     * there are 2^(n-i-1) : A[i] will be the biggest one
     * @param A
     * @return
     */
    public int sumSubseqWidths(int[] A) {

        long mod = (long) (1e9 + 7);

        int n = A.length;
        Arrays.sort(A);

        long[] binaryMod = new long[n];
        long now = 1;
        for (int i = 0; i < n; i++) {
            binaryMod[i] = now % mod;
            now = (now << 1) % mod;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + binaryMod[i] * A[i]) % mod;
            ans = (ans - binaryMod[n - i - 1] * A[i]) % mod;
        }

        ans = (ans + mod) % mod;
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new P891_SumofSubsequenceWidths().sumSubseqWidths(new int[]{2, 1, 3}));
    }

}
