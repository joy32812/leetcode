package com.leetcode;

/**
 * Created by xiaoyuan on 17/09/2017.
 */
public class P680_ValidPalindromeII {

    public boolean validPalindrome(String s) {
        if (isOkay(s)) {return true;}

        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return (isOkay(s.substring(l, r)) || isOkay(s.substring(l + 1, r + 1)));
            }
            l++;
            r--;
        }

        return false;
    }

    boolean isOkay(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {return false;}
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P680_ValidPalindromeII().validPalindrome("aba"));
        System.out.println(new P680_ValidPalindromeII().validPalindrome("abc"));
        System.out.println(new P680_ValidPalindromeII().validPalindrome("abca"));
    }

}
