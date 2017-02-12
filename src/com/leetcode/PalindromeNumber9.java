package com.leetcode;

/**
 * Created by xiaoyuan on 12/02/2017.
 */
public class PalindromeNumber9 {
    public boolean isPalindrome(int x) {
        String oldStr = "" + x;
        String newStr = new StringBuilder(oldStr).reverse().toString();
        return oldStr.equals(newStr);
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber9().isPalindrome(121));
        System.out.println(new PalindromeNumber9().isPalindrome(1221));
        System.out.println(new PalindromeNumber9().isPalindrome(0));
        System.out.println(new PalindromeNumber9().isPalindrome(-1));
        System.out.println(new PalindromeNumber9().isPalindrome(11234234));
    }
}
