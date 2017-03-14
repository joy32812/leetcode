package com.leetcode;

/**
 * Created by xiaoyuan on 14/03/2017.
 */
public class P125_ValidPalindrome {

    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
                sb.append(ch);
            }
        }

        s = sb.toString();

        int n = s.length();
        if (n == 0) {return true;}

        int l = 0, r = n - 1;
        while (l < r) {
            String a = ("" + s.charAt(l)).toLowerCase();
            String b = ("" + s.charAt(r)).toLowerCase();
            if (!a.equals(b)) {return false;}
            l ++;
            r --;
        }

        return true;
    }

}
