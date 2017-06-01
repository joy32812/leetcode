package com.leetcode;

/**
 * Created by xiaoyuan on 01/06/2017.
 */
public class P415_AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int a = num1.length() - 1;
        int b = num2.length() - 1;

        int adv = 0;
        while (true) {
            if (a < 0 && b < 0 && adv == 0) {break;}

            int now = (a >= 0 ? num1.charAt(a) - '0' : 0) + (b >= 0 ? num2.charAt(b) - '0' : 0) + adv;
            sb.append(now % 10);
            adv = now / 10;

            a--;
            b--;
        }

        return sb.reverse().toString();
    }

}
