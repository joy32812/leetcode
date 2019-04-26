package com.leetcode;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 26/02/2017.
 * DP
 *
 * 注意特殊情况
 * 1. 空串
 * 2. p第一个为*, 初始化需要注意
 */
public class P44_WildcardMatching {

    Map<String, Boolean> dpMap;
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) return true;
        if (s == null || p == null) return false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            if (i - 1 == 0 && p.charAt(i - 1) == '*' && p.charAt(i) == '*') continue;
            sb.append(p.charAt(i));
        }

        dpMap = new HashMap<>();

        return match(s, 0,  sb.toString(),0);
    }

    private boolean match(String s, int a, String p, int b) {
        String key = a + "_" + b;
        if (dpMap.containsKey(key)) return dpMap.get(key);

        if (a == s.length() && b == p.length()) {
            dpMap.put(key, true);
            return true;
        }

        if (a < s.length() && b < p.length() && s.charAt(a) == p.charAt(b)) {
            boolean result = match(s, a + 1, p, b + 1);
            dpMap.put(key, result);
            return result;
        }
        if (b < p.length() && p.charAt(b) == '?') {
            boolean result = match(s, a + 1, p, b + 1);
            dpMap.put(key, result);
            return result;
        }

        if (b < p.length() && p.charAt(b) == '*') {
            for (int i = a; i <= s.length(); i++) {
                if (match(s, i, p, b + 1)) {
                    dpMap.put(key, true);
                    return true;
                }
            }
        }

        dpMap.put(key, false);
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new P44_WildcardMatching().isMatch("aa", "*"));
//        System.out.println(new P44_WildcardMatching().isMatch("aab", "c*a*b"));
//        System.out.println(new P44_WildcardMatching().isMatch("c", "*?*"));
//        System.out.println(new P44_WildcardMatching().isMatch("", "*"));
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
