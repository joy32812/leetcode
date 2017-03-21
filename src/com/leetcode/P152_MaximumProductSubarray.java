package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 21/03/2017.
 */
public class P152_MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        long ans = nums[0];

        int l = 0;
        for(int i = 0; i <= nums.length; i++) {
            if (i == nums.length || nums[i] == 0) {
                if (i < nums.length && nums[i] == 0) {ans = Math.max(ans, 0);}

                ans = Math.max(ans, getMaxProd(nums, l, i - 1));
                l = i + 1;
            }
        }

        return (int)ans;
    }

    private long getMaxProd(int[] nums, int l, int r) {
        if (l > r) {
            return 0l + Integer.MIN_VALUE;
        }
        long result = nums[l];
        long total = nums[l];
        for (int i = l + 1; i <= r; i++) {
            total *= nums[i];
        }
        result = Math.max(result, total);

        long tpTotal = total;
        for (int i = l; i < r; i++) {
            tpTotal /= nums[i];
            result = Math.max(result, tpTotal);
        }

        tpTotal = total;
        for (int i = r; i > l; i--) {
            tpTotal /= nums[i];
            result = Math.max(result, tpTotal);
        }

        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(new P152_MaximumProductSubarray().maxProduct(new int[]{0, 2}));
        System.out.println(new P152_MaximumProductSubarray().maxProduct(new int[]{100, -2, -3, 5, -9}));
    }

}
