package com.leetcode;

public class B4 {


    public int maxChunksToSorted(int[] arr) {

        int n = arr.length;
        int[] dp = new int[n];

        int min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = min;
            min = Math.min(min, arr[i]);
        }

        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);

            if (max <= dp[i]) {
                ans++;

                max = Integer.MIN_VALUE;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(new B4().maxChunksToSorted(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new B4().maxChunksToSorted(new int[]{2, 1, 3, 4, 4}));
    }

}
