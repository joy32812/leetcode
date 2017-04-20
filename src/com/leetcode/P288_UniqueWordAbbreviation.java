package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaoyuan on 20/04/2017.
 */
public class P288_UniqueWordAbbreviation {

    private Map<String, Integer> abbrMap;
    private Set<String> wordSet;

    public P288_UniqueWordAbbreviation(String[] dictionary) {
        abbrMap = new HashMap<>();
        wordSet = new HashSet<>();
        for (String w : dictionary) {
            if (w.length() <= 2) {continue;}
            String abbr = "" + w.charAt(0) + (w.length() - 2) + w.charAt(w.length() - 1);

            wordSet.add(w);
            if (!abbrMap.containsKey(abbr)) {
                abbrMap.put(abbr, 1);
            } else {
                abbrMap.put(abbr, abbrMap.get(abbr) + 1);
            }
        }
    }

    public boolean isUnique(String word) {
        if (word.length() <= 2) {return true;}

        String abbr = "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
        if (wordSet.contains(word)) {
            if (abbrMap.get(abbr) == 1) {
                return true;
            }
            return false;
        }

        return !abbrMap.containsKey(abbr);
    }
}
