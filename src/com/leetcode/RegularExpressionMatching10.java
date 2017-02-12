package com.leetcode;

/**
 * Created by xiaoyuan on 12/02/2017.
 */
public class RegularExpressionMatching10 {

    public boolean isMatch(String s, String p) {
        int la = s.length();
        int lb = p.length();

        if (la == 0 && lb != 0) {
            if (lb % 2 != 0) {
                return false;
            }
            for (int i = 0; i < lb; i += 2) {
                if (p.charAt(i + 1) != '*') {
                    return false;
                }
            }

            return true;
        }
        if (la == 0 && lb == 0) {
            return true;
        }
        if (la != 0 && lb == 0) {
            return false;
        }

        for (int i = 0; i < la; i++) {
            char cs = s.charAt(i);
            if (lb <= i) {
                return false;
            }

            char cp = p.charAt(i);
            if (i + 1 < lb && p.charAt(i + 1) == '*') {
                // x*
                for (int j = i; j <= la; j++) {
                    if (isMatch(s.substring(j), p.substring(i + 2))) {
                        return true;
                    }
                    if (cp != '.' && j < la && s.charAt(j) != cp) {
                        break;
                    }
                }
            } else if (cp == '.') {
                // .
                return isMatch(s.substring(i + 1), p.substring(i + 1));
            } else {
                // other
                if (cs != cp) {
                    return false;
                }
                return isMatch(s.substring(i + 1), p.substring(i + 1));
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching10().isMatch("a", ".*..a*"));

        System.out.println(new RegularExpressionMatching10().isMatch("aa", "a"));
        System.out.println(new RegularExpressionMatching10().isMatch("aa", "aa"));
        System.out.println(new RegularExpressionMatching10().isMatch("aaa", "aa"));

        System.out.println(new RegularExpressionMatching10().isMatch("aa", "a*"));
        System.out.println(new RegularExpressionMatching10().isMatch("aa", ".*"));
        System.out.println(new RegularExpressionMatching10().isMatch("ab", ".*"));
        System.out.println(new RegularExpressionMatching10().isMatch("aab", "c*a*b"));

        System.out.println(new RegularExpressionMatching10().isMatch("aaab", ".*b"));
    }

}
