package com.leetcode;

/**
 * Created by xiaoyuan on 08/04/2017.
 */
public class P233_NumberofDigitOne {

    public int countDigitOne(int n) {

        if (n <= 0) {return 0;}

        int ans = 0;
        int base = 1;

        int last = 0;
        while (n > 0) {
            int a = n / 10;
            int b = n % 10;

            ans += base * a;
            if (b == 0) {

            } else if (b == 1) {
                ans += (last + 1);
            } else {
                ans += base;
            }
            last = b * base + last;

            base *= 10;
            n = a;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P233_NumberofDigitOne().countDigitOne(1));
        System.out.println(new P233_NumberofDigitOne().countDigitOne(13));
        System.out.println(new P233_NumberofDigitOne().countDigitOne(100));
    }

}
