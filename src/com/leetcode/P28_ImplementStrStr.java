package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 19/02/2017.
 * KMP algorithm
 */
public class P28_ImplementStrStr {

    private List<Integer> P;

    public void initP(String needle) {
        P = new ArrayList<Integer>();
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

    public int kmp(String haystack, String needle) {
        int j = -1;

        for (int i = 0; i < haystack.length(); i++) {
            while (j > -1 && needle.charAt(j + 1) != haystack.charAt(i)) {
                j = P.get(j);
            }

            if (needle.charAt(j + 1) == haystack.charAt(i)) {
                j++;
            }
            if (j == needle.length() - 1) {
                return i - j;
            }
        }

        return -1;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        initP(needle);
        return kmp(haystack, needle);
    }

    public static void main(String[] args) {
        System.out.println(new P28_ImplementStrStr().strStr("ababababbb", "abc"));
    }

}
