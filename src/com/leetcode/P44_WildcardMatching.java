package com.leetcode;

import java.util.Date;

/**
 * Created by xiaoyuan on 26/02/2017.
 * DP
 *
 * 注意特殊情况
 * 1. 空串
 * 2. p第一个为*, 初始化需要注意
 */
public class P44_WildcardMatching {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        if (p.length() > 0) {
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '*') {
                    dp[0][i + 1] = true;
                } else {
                    break;
                }
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (dp[i][j]) {
                    continue;
                }
                char sCh = s.charAt(i - 1);
                char pCh = p.charAt(j - 1);

                if (pCh == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pCh == '*') {
                    if (dp[i - 1][j - 1]) {
                        for (int k = i; k <= s.length(); k++) {
                            dp[k][j] = true;
                        }
                    }
                    if (dp[i][j - 1]) {
                        dp[i][j] = true;
                    }
                } else {
                    if (sCh == pCh && dp[i - 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        System.out.println(new P44_WildcardMatching().isMatch("aab", "c*a*b"));
        System.out.println(new P44_WildcardMatching().isMatch("c", "*?*"));
        System.out.println(new P44_WildcardMatching().isMatch("", "*"));
//        System.out.println(new P44_WildcardMatching().isMatch("aa", "aa*"));
//        System.out.println(new P44_WildcardMatching().isMatch("aa", "aa"));
//        System.out.println(new P44_WildcardMatching().isMatch("aaa", "aa"));
//        System.out.println(new P44_WildcardMatching().isMatch("aa", "*"));
//        System.out.println(new P44_WildcardMatching().isMatch("aa", "*"));
//        System.out.println(new P44_WildcardMatching().isMatch("aba", "?*"));
//        System.out.println(new P44_WildcardMatching().isMatch("aab", "c*a*b"));
//        System.out.println(new Date().getTime());
//        System.out.println(new P44_WildcardMatching().isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
//        System.out.println(new Date().getTime());
    }

}
