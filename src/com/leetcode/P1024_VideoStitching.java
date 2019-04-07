package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class P1024_VideoStitching {

    /**
     * sort and dp
     * @param clips
     * @param T
     * @return
     */
    public int videoStitching(int[][] clips, int T) {

        Arrays.sort(clips, Comparator.comparingInt(a -> a[1]));

        int n = clips.length;
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            int[] cp = clips[i];
            if (cp[0] == 0) {
                dp[i] = 1;
                continue;
            }

            for (int j = 0; j < i; j++) {
                if (dp[j] == Integer.MAX_VALUE) continue;
                int[] before = clips[j];
                if (before[1] < cp[0]) continue;

                if (dp[i] > dp[j] + 1) dp[i] = dp[j] + 1;
            }
        }


        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            int[] cp = clips[i];
            if (cp[1] >= T) ans = Math.min(ans, dp[i]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {

    }
}
