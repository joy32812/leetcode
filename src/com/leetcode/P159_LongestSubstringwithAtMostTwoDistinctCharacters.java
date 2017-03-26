package com.leetcode;

/**
 * Created by xiaoyuan on 26/03/2017.
 */
public class P159_LongestSubstringwithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2) {return s.length();}
        int n = s.length();

        String[] twoChars = new String[n];
        int[] cnt = new int[n];
        int[] dp = new int[n];

        // init
        cnt[0] = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cnt[i] = cnt[i - 1] + 1;
            } else {
                cnt[i] = 1;
            }
        }

        int ans = 2;
        dp[0] = 1;
        twoChars[0] = "" + s.charAt(0);
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1) || (twoChars[i - 1].length() == 2 && (twoChars[i - 1].charAt(0) == s.charAt(i) || twoChars[i -1].charAt(1) == s.charAt(i)))) {
                dp[i] = dp[i - 1] + 1;
                twoChars[i] = twoChars[i - 1];
            } else {
                dp[i] = 1 + cnt[i - 1];
                twoChars[i] = "" + s.charAt(i - 1) + s.charAt(i);
            }
            ans = Math.max(ans, dp[i]);
        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P159_LongestSubstringwithAtMostTwoDistinctCharacters().lengthOfLongestSubstringTwoDistinct("aabbaaabbbaaa"));
    }
}
