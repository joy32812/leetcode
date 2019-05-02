package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 21/04/2017.
 */
public class P291_WordPatternII {

    private Map<String, String> pattern2wordMap;
    private Map<String, String> word2patternMap;


    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null) {return false;}

        pattern2wordMap = new HashMap<>();
        word2patternMap = new HashMap<>();

        return ifMatch(pattern, 0, str, 0);

    }

    private boolean ifMatch(String p, int pl, String s, int sl) {
        if (pl >= p.length() && sl >= s.length()) return true;
        if (pl >= p.length() || sl >= s.length()) return false;


        String key = "" + p.charAt(pl);
        if (pattern2wordMap.containsKey(key)) {
            String w = pattern2wordMap.get(key);
            if (sl + w.length() > s.length() || !s.substring(sl, sl + w.length()).equals(w)) return false;

            return ifMatch(p, pl + 1, s, sl + w.length());
        }


        for (int i = sl; i < s.length(); i++) {
            String now = s.substring(sl, i + 1);
            if (word2patternMap.containsKey(now)) continue;

            pattern2wordMap.put(key, now);
            word2patternMap.put(now, key);

            if (ifMatch(p, pl + 1, s, i + 1)) return true;

            pattern2wordMap.remove(key);
            word2patternMap.remove(now);
        }


        return false;
    }


    public static void main(String[] args) {
        System.out.println(new P291_WordPatternII().wordPatternMatch("aba", "aaaa"));
//        System.out.println(new P291_WordPatternII().wordPatternMatch("abab", "redblueredblue"));
//        System.out.println(new P291_WordPatternII().wordPatternMatch("aaaa", "redblueredblue"));
//        System.out.println(new P291_WordPatternII().wordPatternMatch("aaaa", "asdasdasdasd"));
    }
}
