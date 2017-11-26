package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 26/11/2017.
 */
public class P737_SentenceSimilarityII {

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {

        Map<String, String> fatherMap = new HashMap<>();

        for (String[] p : pairs) {

            String s = p[0];
            String t = p[1];

            String sFather = getFather(fatherMap, s);
            String tFather = getFather(fatherMap, t);
            fatherMap.put(sFather, tFather);
        }

        if (words1.length != words2.length) return false;

        for (int i = 0; i < words1.length; i++) {

            String w1 = words1[i];
            String w2 = words2[i];

            if (!getFather(fatherMap, w1).equals(getFather(fatherMap, w2))) return false;
        }

        return true;
    }

    private String getFather(Map<String, String> fatherMap, String t) {
        while (fatherMap.containsKey(t) && !fatherMap.get(t).equals(t)) {
            t = fatherMap.get(t);
        }
        fatherMap.put(t, t);
        return t;
    }

}
