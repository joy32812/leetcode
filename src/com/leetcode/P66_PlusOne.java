package com.leetcode;

/**
 * Created by xiaoyuan on 28/02/2017.
 */
public class P66_PlusOne {

    public int[] plusOne(int[] digits) {
        int one = 1;
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int v = digits[i] + one + carry;
            one = 0;
            digits[i] = v % 10;
            carry = v / 10;

            if (carry == 0) {
                break;
            }
        }

        if (carry == 0) {
            return digits;
        } else {
            int[] ans = new int[digits.length + 1];
            ans[0] = carry;
            System.arraycopy(digits, 0, ans, 1, digits.length);
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {9, 9, 9};
        int[] ans = new P66_PlusOne().plusOne(nums);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

}
