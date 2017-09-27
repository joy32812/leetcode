package com.leetcode;

/**
 * Created by xiaoyuan on 27/09/2017.
 */
public class P600_NonnegativeIntegerswithoutConsecutiveOnes {

    public int findIntegers(int num) {

        int[][] dp = new int[60][2];
        dp[0][0] = 1;
        for (int i = 1; i < 32; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        String binaryNumStr = Integer.toBinaryString(num);
        int len = binaryNumStr.length();
        char[] chars = binaryNumStr.toCharArray();


        int ans = 0;
        int i = 0;
        for (i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '1') {
                ans += dp[len - i][0];
                if (i - 1 >= 0 && chars[i - 1] == '1') break;
            }
        }

        return ans + (i == len ? 1 : 0);
    }

    public static void main(String[] args) {
        System.out.println(new P600_NonnegativeIntegerswithoutConsecutiveOnes().findIntegers(5));
    }

}
