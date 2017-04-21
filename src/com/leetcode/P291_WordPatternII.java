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

        return ifMatch(pattern, 0, pattern.length() - 1, str, 0, str.length() - 1);

    }

    private boolean ifMatch(String p, int pl, int pr, String s, int sl, int sr) {
        if (pl > pr && sl > sr) {return true;}
        if (pl > pr) {return false;}
        if (sl > sr) {return false;}

        String key = "" + p.charAt(pl);
        if (pattern2wordMap.containsKey(key)) {
            String now = pattern2wordMap.get(key);
            if(sr + 1 - sl < now.length() || s.substring(sl, sr + 1).indexOf(now) != 0) {
                return false;
            };

            return ifMatch(p, pl + 1, pr, s, sl + now.length(), sr);
        }

        for (int i = sl; i <= sr; i++) {
            String now = s.substring(sl, i + 1);
            if (word2patternMap.containsKey(now)) {continue;}


            pattern2wordMap.put(key, now);
            word2patternMap.put(now, key);

            if (ifMatch(p, pl + 1, pr, s, sl + now.length(), sr)) {return true;}

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
