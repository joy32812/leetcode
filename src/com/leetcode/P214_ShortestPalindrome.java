package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 03/04/2017.
 */
public class P214_ShortestPalindrome {

    private List<Integer> P;

    public String shortestPalindrome(String s) {
        if (s.length() <= 1) {return s;}

        getNextP(s + "#" + new StringBuilder(s).reverse());

        return new StringBuilder(s.substring(P.get(P.size() - 1) + 1)).reverse() + s;
    }

    private void getNextP(String needle) {
        P = new ArrayList<Integer>();
        P.add(-1);

        int j = -1;
        for (int i = 1; i < needle.length(); i++) {
            while (j > -1 && needle.charAt(j + 1) != needle.charAt(i)) {
                j = P.get(j);
            }
            if (needle.charAt(j + 1) == needle.charAt(i)) {
                j ++;
            }
            P.add(j);
        }
    }

    public static void main(String[] args) {
        System.out.println(new P214_ShortestPalindrome().shortestPalindrome("aabba"));
        System.out.println(new P214_ShortestPalindrome().shortestPalindrome("aaaaab"));
        System.out.println(new P214_ShortestPalindrome().shortestPalindrome("aaaa"));
        System.out.println(new P214_ShortestPalindrome().shortestPalindrome("aacecaaa"));
        System.out.println(new P214_ShortestPalindrome().shortestPalindrome("abcd"));
    }

}
