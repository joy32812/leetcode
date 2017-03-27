package com.leetcode;

/**
 * Created by xiaoyuan on 27/03/2017.
 */
public class P171_ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int ans = 0;
        int base = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'Z') {
                ans += 26 * base;
            } else {
                ans += (s.charAt(i) - 'A' + 1) * base;
            }

            base *= 26;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P171_ExcelSheetColumnNumber().titleToNumber("A"));
        System.out.println(new P171_ExcelSheetColumnNumber().titleToNumber("Z"));
        System.out.println(new P171_ExcelSheetColumnNumber().titleToNumber("AA"));
        System.out.println(new P171_ExcelSheetColumnNumber().titleToNumber("AB"));
        System.out.println(new P171_ExcelSheetColumnNumber().titleToNumber("FWSDF"));
    }

}
