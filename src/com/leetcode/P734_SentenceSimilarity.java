package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaoyuan on 26/11/2017.
 */
public class P734_SentenceSimilarity {

    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] p : pairs) {
            map.computeIfAbsent(p[0], k -> new HashSet<String>()).add(p[1]);
            map.computeIfAbsent(p[1], k -> new HashSet<String>()).add(p[0]);
        }

        if (words1 == null && words2 == null) return true;
        if (words1 == null || words2 == null) return false;
        if (words1.length != words2.length) return false;


        for (int i = 0; i < words1.length; i++) {
            String s = words1[i];
            String t = words2[i];
            if (s.equals(t)) continue;
            if (map.computeIfAbsent(s, k -> new HashSet<String>()).contains(t)) continue;
            if (map.computeIfAbsent(t, k -> new HashSet<String>()).contains(s)) continue;
            return false;
        }

        return true;
    }


    public static void main(String[] args) {

    }

}
