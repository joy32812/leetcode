package com.leetcode;

/**
 * Created by xiaoyuan on 25/05/2017.
 */
public class P392_IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        int a = 0;
        int b = 0;

        while (true) {

            if (a == s.length()) {
                return true;
            }
            if (b == t.length()) {
                return false;
            }

            if (s.charAt(a) == t.charAt(b)) {
                a++;
                b++;
            } else {
                b++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new P392_IsSubsequence().isSubsequence("abc", "ahbgdc"));
        System.out.println(new P392_IsSubsequence().isSubsequence("axc", "ahbgdc"));
    }

}
