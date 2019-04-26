package com.leetcode;

/**
 * Created by xiaoyuan on 30/05/2017.
 */
public class P408_ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null && word == null) return true;
        if (word == null || word == null) return false;
        if (word.equals(abbr)) return true;

        int i = 0;
        int j = 0;

        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                int val = getValue(abbr.substring(j));
                int len = ("" + val).length();
                if (val == 0) return false;

                i += val;
                j += len;
            } else {
                if (word.charAt(i) != abbr.charAt(j)) return false;
                i ++;
                j ++;
            }
        }

        return i == word.length() && j == abbr.length();
    }

    private int getValue(String s) {
        int now = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return now;
            now = now * 10 + (s.charAt(i) - '0');
        }
        return now;
    }

    public static void main(String[] args) {
        System.out.println(new P408_ValidWordAbbreviation().validWordAbbreviation("internationalization", "i12iz4n"));
//        System.out.println(Integer.parseInt(s));
    }

}
