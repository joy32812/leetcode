package com.leetcode;

/**
 * Created by xiaoyuan on 09/04/2017.
 */
public class P238_ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prodFront = new int[n];
        int[] prodBack = new int[n];

        int last = 1;
        for (int i = 0; i < n; i++) {
            prodFront[i] = last * nums[i];
            last = prodFront[i];
        }

        last = 1;
        for (int i = n - 1; i >= 0; i--) {
            prodBack[i] = last * nums[i];
            last = prodBack[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = getValues(prodFront, i - 1) * getValues(prodBack, i + 1);
        }

        return ans;
    }

    private int getValues(int[] prod, int i) {
        if (i < 0 || i >= prod.length) {
            return 1;
        }
        return prod[i];
    }

}
