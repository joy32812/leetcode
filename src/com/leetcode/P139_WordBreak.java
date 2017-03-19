package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 19/03/2017.
 */
public class P139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i - word.length() >= 0 && dp[i - word.length()] && s.substring(i - word.length(), i).equals(word)) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }

}
