package com.leetcode;

import java.util.List;

/**
 * Created by xiaoyuan on 16/04/2017.
 */
public class P260_SingleNumberIII {

    public int[] singleNumber(int[] nums) {

        int xor = 0;
        for (int d : nums) {xor ^= d;}

        int x = ((xor ^ (xor - 1)) + 1) / 2;

        int ans1 = 0;
        for (int d: nums) {
            if ((x & d) != 0) {
                ans1 ^= d;
            }
        }
        int ans2 = 0;
        for (int d: nums) {
            if ((x & d) == 0) {
                ans2 ^= d;
            }
        }

        return new int[]{ans1, ans2};
    }

    public static void main(String[] args) {
        System.out.println(new P260_SingleNumberIII().singleNumber(new int[]{1,2,1,2,3, 5}));
    }


}
