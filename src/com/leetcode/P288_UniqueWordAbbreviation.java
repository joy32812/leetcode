package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaoyuan on 20/04/2017.
 */
public class P288_UniqueWordAbbreviation {

    private Map<String, Set<String>> abbrMap;
    public P288_UniqueWordAbbreviation(String[] dictionary) {
        abbrMap = new HashMap<>();
        for (String w : dictionary) {
            String abbr = w;
            if (w.length() > 2) abbr = "" + w.charAt(0) + (w.length() - 2) + w.charAt(w.length() - 1);

            abbrMap.computeIfAbsent(abbr, k -> new HashSet<>()).add(w);
        }
    }

    public boolean isUnique(String word) {
        String abbr = word;
        if (word.length() > 2) abbr = "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
        if (!abbrMap.containsKey(abbr)) return true;

        return abbrMap.get(abbr).contains(word) && abbrMap.get(abbr).size() == 1;

    }

    public static void main(String[] args) {

        P288_UniqueWordAbbreviation obj = new P288_UniqueWordAbbreviation(new String[]{"deer", "door", "cake", "card"});

        System.out.println(obj.isUnique("dear"));
        System.out.println(obj.isUnique("cart"));
        System.out.println(obj.isUnique("cane"));
        System.out.println(obj.isUnique("make"));

    }
}
