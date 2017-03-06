package com.leetcode;

/**
 * Created by xiaoyuan on 06/03/2017.
 *
 * attention: 0
 */
public class P91_DecodeWays {

    public int numDecodings(String s) {
        if (s.length() == 0) {return 0;}

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for(int i = 1;i <= s.length(); i++) {
            char ch = s.charAt(i - 1);

            boolean okay = false;
            if (i > 1) {
                char beforeChar = s.charAt(i - 2);
                int num = Integer.parseInt("" + beforeChar + ch);
                if (num >= 1 && num <= 26) {
                    dp[i] = dp[i - 2];
                    okay = true;
                }
            }

            if (ch >= '1' && ch <= '9') {
                dp[i] += dp[i-1];
                okay = true;
            } else if (okay == true) {
                dp[i - 1] = 0;
            }

            if (okay == false) {
                return 0;
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new P91_DecodeWays().numDecodings("10100"));
//        System.out.println(new P91_DecodeWays().numDecodings("10"));
//        System.out.println(new P91_DecodeWays().numDecodings("01"));
//        System.out.println(new P91_DecodeWays().numDecodings("123"));
    }

}
