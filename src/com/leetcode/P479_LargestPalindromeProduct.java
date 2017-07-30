package com.leetcode;

/**
 * Created by xiaoyuan on 28/07/2017.
 */
public class P479_LargestPalindromeProduct {

    public int largestPalindrome(long n) {
        if (n == 1) {return 9;}

        int max = (int)Math.pow(10, n) - 1;

        for (int i = max - 1; i > max / 10; i--) {
            long u = Long.valueOf(i + new StringBuilder().append(i).reverse().toString());

            for (long x = max; x * x >= u; x--) {
                if (u % x == 0) {
                    return (int)(u % 1337);
                }
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new P479_LargestPalindromeProduct().largestPalindrome(2));
        System.out.println(new P479_LargestPalindromeProduct().largestPalindrome(8));
        System.out.println(new P479_LargestPalindromeProduct().largestPalindrome(7));
        System.out.println(new P479_LargestPalindromeProduct().largestPalindrome(6));
    }
}
