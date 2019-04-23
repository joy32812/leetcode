package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P890_FindandReplacePattern {


    /**
     * easy
     * @param words
     * @param pattern
     * @return
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        if (words == null || pattern == null) return ans;

        for (String w : words) {
            if (match(w, pattern)) ans.add(w);
        }


        return ans;
    }

    private boolean match(String w, String pattern) {
        if (w.length() != pattern.length()) return false;

        Map<Character, Character> wMap = new HashMap<>();
        Map<Character, Character> pMap = new HashMap<>();

        for (int i = 0; i < w.length(); i++) {
            char chw = w.charAt(i);
            char chp = pattern.charAt(i);

            if (wMap.containsKey(chw) && wMap.get(chw) != chp) return false;
            if (pMap.containsKey(chp) && pMap.get(chp) != chw) return false;

            wMap.put(chw, chp);
            pMap.put(chp, chw);
        }

        return true;
    }

}
