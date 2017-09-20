package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 19/09/2017.
 */
public class P493_ReversePairs {

    int[] BIT;
    int size;
    public int reversePairs(int[] nums) {

        long[] numsCopy = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {numsCopy[i] = nums[i];}
        Arrays.sort(numsCopy);

        BIT = new int[nums.length + 1];
        size = nums.length;

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = Arrays.binarySearch(numsCopy, 2L * nums[i] + 1L);
            if (index < 0) {
                index = -index - 1;
            }
            ans += query(size) - query(index);

            index = Arrays.binarySearch(numsCopy, nums[i]);
            update(index + 1, 1);
        }

        return ans;
    }

    private void update(int x, int d) {
        while (x <= size) {
            BIT[x] += d;
            x += (x & -x);
        }
    }

    private int query(int x) {
        int res = 0;
        while (x > 0) {
            res += BIT[x];
            x -= (x & -x);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P493_ReversePairs().reversePairs(new int[]{
                2147483647,2147483647,2147483647,2147483647,2147483647,2147483647
        }));
        System.out.println(new P493_ReversePairs().reversePairs(new int[]{1, 3, 2, 3, 1}));
        System.out.println(new P493_ReversePairs().reversePairs(new int[]{2, 4, 3, 5, 1}));

    }

}
