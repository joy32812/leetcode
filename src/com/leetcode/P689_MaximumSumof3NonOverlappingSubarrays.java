package com.leetcode;

/**
 * Created by xiaoyuan on 02/10/2017.
 */
public class P689_MaximumSumof3NonOverlappingSubarrays {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        int n = nums.length;
        int[] sum = new int[n];
        int[] W = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        // sum
        for (int i = 0; i < n; i++) {
            sum[i] = (i - 1 >= 0 ? sum[i - 1] : 0) + nums[i];
        }

        // W
        for (int i = 0; i < n; i++) {
            int l = i - 1;
            int r = i + k - 1;
            if (r >= n) break;

            W[i] = sum[r] - (l >= 0 ? sum[l] : 0);
        }

        // left
        left[0] = 0;
        for (int i = 1; i < n; i++) {
            if (W[i] > W[left[i - 1]]) {
                left[i] = i;
            } else {
                left[i] = left[i - 1];
            }
        }

        // right
        right[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (W[i] >= W[right[i + 1]]) {
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }


        int now = 0;
        int[] ans = new int[3];
        for (int j = 0; j < n; j++) {
            int a = j - k;
            int b = j + k;
            if (a < 0 || b >= n) continue;

            int tmp = W[left[a]] + W[j] + W[right[b]];
            if (tmp > now) {
                now = tmp;
                ans = new int[]{left[a], j, right[b]};
            } else if (tmp == now) {
                if (ans[0] > left[a]) {
                    ans = new int[]{left[a], j, right[b]};
                } else if (ans[0] == left[a] && ans[1] > j) {
                    ans = new int[]{left[a], j, right[b]};
                } else if (ans[0] == left[a] && ans[1] == j && ans[2] > right[b]) {
                    ans = new int[]{left[a], j, right[b]};
                }
            }

        }


        return ans;
    }

}
