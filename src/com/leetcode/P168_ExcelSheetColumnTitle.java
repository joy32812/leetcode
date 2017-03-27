package com.leetcode;

/**
 * Created by xiaoyuan on 27/03/2017.
 *
 * like 26
 */
public class P168_ExcelSheetColumnTitle {

    public String convertToTitle(int n) {

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int a = n / 26;
            int b = n % 26;
            if (b == 0) {
                a --;
                sb.append('Z');
            } else {
                sb.append((char)((int)'A' + b - 1));
            }

            n = a;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new P168_ExcelSheetColumnTitle().convertToTitle(1));
        System.out.println(new P168_ExcelSheetColumnTitle().convertToTitle(10));
        System.out.println(new P168_ExcelSheetColumnTitle().convertToTitle(26));
        System.out.println(new P168_ExcelSheetColumnTitle().convertToTitle(27));
        System.out.println(new P168_ExcelSheetColumnTitle().convertToTitle(30));
        System.out.println(new P168_ExcelSheetColumnTitle().convertToTitle(52));
        System.out.println(new P168_ExcelSheetColumnTitle().convertToTitle(26*26));
        System.out.println(new P168_ExcelSheetColumnTitle().convertToTitle(26*26 + 26));
    }

}
