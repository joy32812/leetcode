package com.leetcode;

/**
 * Created by xiaoyuan on 24/05/2017.
 */
public class P389_FindtheDifference {

    public char findTheDifference(String s, String t) {

        int[] numArr = new int[30];
        for (char ch : s.toCharArray()) {
            numArr[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            if (numArr[ch - 'a'] == 0) {return ch;}
            numArr[ch - 'a']--;
        }

        return 'a';
    }

}
