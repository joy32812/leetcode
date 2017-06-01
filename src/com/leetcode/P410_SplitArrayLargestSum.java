package com.leetcode;

/**
 * Created by xiaoyuan on 01/06/2017.
 */
public class P410_SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {

        long total = 0;
        long l = 0;
        for (int d : nums) {
            total += d;
            l = Math.max(d, l);
        }

        if (m == 1) {return (int)total;}

        long r = total;

        while (l < r) {
            long mid = (l + r) / 2;
            if (okay(nums, m, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }



        return (int)l;
    }

    private boolean okay(int[] nums, int m, long mid) {
        long sum = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > mid) {
                cnt++;

                if (cnt == m) {return false;}
                sum = nums[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P410_SplitArrayLargestSum().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }

}


