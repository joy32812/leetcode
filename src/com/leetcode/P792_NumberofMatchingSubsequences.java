package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class P792_NumberofMatchingSubsequences {

    public int numMatchingSubseq(String S, String[] words) {

        Map<Character, TreeSet<Integer>> charMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            charMap.computeIfAbsent(ch, k -> new TreeSet<>()).add(i);
        }

        int ans = 0;
        for (String w : words) {
            if (okay(charMap, w)) ans ++;
        }

        return ans;
    }


    private boolean okay(Map<Character, TreeSet<Integer>> charMap, String w) {

        int now = 0;
        for (char ch : w.toCharArray()) {
            TreeSet<Integer> treeSet = charMap.computeIfAbsent(ch, k -> new TreeSet<>());
            Integer ceiling = treeSet.ceiling(now);
            if (ceiling == null) return false;
            now = ceiling + 1;
        }

        return true;
    }

}
