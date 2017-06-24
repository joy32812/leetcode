package com.leetcode;

/**
 * Created by xiaoyuan on 24/06/2017.
 */
public class P520_DetectCapital {

    public boolean detectCapitalUse(String word) {
        return allLower(word) || allUpper(word) || (allUpper(word.substring(0, 1)) && allLower(word.substring(1)));
    }

    boolean allLower(String s) {
        return s.equals(s.toLowerCase());
    }
    boolean allUpper(String s) {
        return s.equals(s.toUpperCase());
    }

    public static void main(String[] args) {
        System.out.println(new P520_DetectCapital().detectCapitalUse("a"));
        System.out.println(new P520_DetectCapital().detectCapitalUse("A"));
        System.out.println(new P520_DetectCapital().detectCapitalUse("Acb"));
        System.out.println(new P520_DetectCapital().detectCapitalUse("AcB"));
    }
}
