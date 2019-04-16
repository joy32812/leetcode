package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class P819_MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = Arrays.stream(banned).collect(Collectors.toSet());

        String lowerStr = paragraph.replaceAll("[!?',;.]", " ").toLowerCase();
        String[] split = lowerStr.split(" ");

        Map<String, Integer> cntMap = new HashMap<>();
        for (String s : split) {
            if (s.length() == 0) continue;
            if (bannedSet.contains(s)) continue;
            cntMap.put(s, cntMap.getOrDefault(s, 0) + 1);
        }

        String ans = "";
        int num = 0;
        for (String s : cntMap.keySet()) {
            if (cntMap.get(s) > num) {
                ans = s;
                num = cntMap.get(s);
            }
        }

        return ans;
    }

}
