package com.leetcode;

/**
 * Created by xiaoyuan on 27/06/2017.
 */
public class P541_ReverseStringII {

    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2 * k) {
            sb.append(new StringBuilder(s.substring(i, Math.min(i + k, s.length()))).reverse());
            if (i + k < s.length()) {
                sb.append(s.substring(i + k, Math.min(s.length(), i + 2 * k)));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P541_ReverseStringII().reverseStr("a", 4));
    }
}
