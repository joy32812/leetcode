package com.leetcode;

import java.math.BigInteger;

/**
 * Created by xiaoyuan on 28/03/2017.
 */
public class P189_RotateArray {

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;
        int gcd = new BigInteger("" + n).gcd(new BigInteger("" + k)).intValue();

        for (int i = 0; i < gcd; i++) {
            int now = i;
            int tmp = nums[i];

            int x = i;
            while (true) {
                int before = (x + n - k) % n;
                if (before == now) {
                    nums[x] = tmp;
                    break;
                }
                nums[x] = nums[before];
                x = before;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        new P189_RotateArray().rotate(nums, 8);

        for (int d : nums) {
            System.out.println(d);
        }
    }
}
