package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 20/04/2017.
 */
public class P290_WordPattern {

    private Map<String, String> pattern2WordMap;
    private Map<String, String> word2PatternMap;
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0) {return false;}

        String[] strArray = str.split(" ");
        if (strArray.length != pattern.length()) {return false;}


        pattern2WordMap = new HashMap<>();
        word2PatternMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            String pat = "" + pattern.charAt(i);
            String word = strArray[i];

            if (pattern2WordMap.get(pat) == null && word2PatternMap.get(word) == null) {
                pattern2WordMap.put(pat, word);
                word2PatternMap.put(word, pat);
            } else if (pattern2WordMap.get(pat) == null) {
                return false;
            } else if (word2PatternMap.get(word) == null) {
                return false;
            } else {
                if (!pattern2WordMap.get(pat).equals(word)) {return false;}
                if (!word2PatternMap.get(word).equals(pat)) {return false;}
            }
        }

        return true;
    }

}
