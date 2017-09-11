package com.leetcode;

/**
 * Created by xiaoyuan on 10/09/2017.
 */
public class P673_NumberofLongestIncreasingSubsequence {

    private class Bucket {
        int len;
        int num;

        public Bucket(int len, int num) {
            this.len = len;
            this.num = num;
        }
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {return 0;}

        int n = nums.length;
        Bucket[] dp = new Bucket[n];

        dp[0] = new Bucket(1, 1);
        for (int i = 1; i < n; i++) {
            dp[i] = new Bucket(1, 1);
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int len = dp[j].len + 1;
                    int num = dp[j].num;

                    if (len == dp[i].len) {
                        dp[i].num += num;
                    } else if (len > dp[i].len) {
                        dp[i].num = num;
                        dp[i].len = len;
                    }
                }
            }
        }


        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(dp[i].len, maxLen);
        }


        int ans = 0;

        for (Bucket b : dp) {
            if (b.len == maxLen) {
                ans += b.num;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P673_NumberofLongestIncreasingSubsequence().findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(new P673_NumberofLongestIncreasingSubsequence().findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
    }

}
