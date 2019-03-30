package com.leetcode;

public class P926_FlipStringtoMonotoneIncreasing {

    /**
     * median
     * prefix sum
     * @param S
     * @return
     */
    public int minFlipsMonoIncr(String S) {
        if (S == null || S.length() <= 1) return 0;

        int n = S.length();
        int[] sums = new int[n];

        for (int i = 0; i < n; i++) {
            sums[i] = (i - 1 >= 0 ? sums[i - 1] : 0) + (S.charAt(i) == '1' ? 1 : 0);
        }

        int ans = n - sums[n - 1];
        for (int i = 0; i < n; i++) {
            int left = sums[i];
            int right = (n - 1 - i) - (sums[n - 1] - sums[i]);
            ans = Math.min(ans, left + right);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P926_FlipStringtoMonotoneIncreasing().minFlipsMonoIncr("00110"));
        System.out.println(new P926_FlipStringtoMonotoneIncreasing().minFlipsMonoIncr("010110"));
        System.out.println(new P926_FlipStringtoMonotoneIncreasing().minFlipsMonoIncr("00011000"));
    }

}
