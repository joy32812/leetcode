package com.leetcode;

import java.util.*;

public class P966_VowelSpellchecker {

    public String[] spellchecker(String[] wordlist, String[] queries) {

        Set<String> exactSet = new HashSet<>(Arrays.asList(wordlist));

        Map<String, String> lowerMap = new HashMap<>();
        for (String w : wordlist) {
            String lw = w.toLowerCase();
            if (lowerMap.containsKey(lw)) continue;
            lowerMap.put(lw, w);
        }


        Map<String, String> vowelMap = new HashMap<>();
        for (String w : wordlist) {
            Set<String> repSet = getRepSet(w.toLowerCase(), 0);
            for (String cw : repSet) {
                if (vowelMap.containsKey(cw)) continue;
                vowelMap.put(cw, w);
            }
        }


        String[] ans = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String qw = queries[i];

            if (exactSet.contains(qw)) ans[i] = qw;
            else if (lowerMap.containsKey(qw.toLowerCase())) ans[i] = lowerMap.get(qw.toLowerCase());
            else if (vowelMap.containsKey(qw.toLowerCase())) ans[i] = vowelMap.get(qw.toLowerCase());
            else ans[i] = "";
        }

        return ans;
    }

    char[] vows = new char[]{'a', 'e', 'i', 'o', 'u'};
    private Set<String> getRepSet(String w, int p) {
        Set<String> ans = new HashSet<>();
        if (p == w.length()) {
            ans.add("");
            return ans;
        }

        Set<String> other = getRepSet(w, p + 1);
        char ch = w.charAt(p);

        char[] nowChars = new char[]{ch};
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            nowChars = vows;
        }

        for (char cr : nowChars) {
            for (String word : other) {
                ans.add("" + cr + word);
            }
        }

        return ans;
    }


    public static void main(String[] args) {

    }

}
