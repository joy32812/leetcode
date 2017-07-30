package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 30/07/2017.
 */
public class P459_RepeatedSubstringPattern {

    private List<Integer> P;

    private void initP(String needle) {
        P = new ArrayList<>();
        P.add(-1);

        int j = -1;

        for (int i = 1; i < needle.length(); i++) {
            while (j > -1 && needle.charAt(j + 1) != needle.charAt(i)) {
                j = P.get(j);
            }

            if (needle.charAt(j + 1) == needle.charAt(i)) {
                j = j + 1;
            }
            P.add(j);
        }
    }

    public boolean repeatedSubstringPattern(String s) {

        initP(s);
        int len = P.get(s.length() - 1);
        int n = s.length();

        return (len >= 0 && n % (n - len - 1) == 0);
    }

    public static void main(String[] args) {
        System.out.println(new P459_RepeatedSubstringPattern().repeatedSubstringPattern("bb"));
        System.out.println(new P459_RepeatedSubstringPattern().repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(new P459_RepeatedSubstringPattern().repeatedSubstringPattern("abab"));
    }

}
