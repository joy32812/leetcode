package com.leetcode;

/**
 * Created by xiaoyuan on 12/02/2017.
 */
public class LongCommonPrefix14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);

            boolean same = true;
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    same = false;
                    break;
                }
            }

            if (!same) {
                break;
            }
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"abbc", "a"};
        System.out.println(new LongCommonPrefix14().longestCommonPrefix(strs));
    }
}
