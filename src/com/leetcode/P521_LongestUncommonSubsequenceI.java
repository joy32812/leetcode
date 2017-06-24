package com.leetcode;

/**
 * Created by xiaoyuan on 24/06/2017.
 */
public class P521_LongestUncommonSubsequenceI {

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {return -1;}

        return Math.max(a.length(), b.length());
    }

}
