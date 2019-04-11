package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P916_WordSubsets {


    public List<String> wordSubsets(String[] A, String[] B) {

        Map<Character, Integer> cntMap = new HashMap<>();

        for (String b : B) {
            Map<Character, Integer> numMap = getNumMap(b);
            for (char ch : numMap.keySet()) {
                if (cntMap.getOrDefault(ch, 0) < numMap.getOrDefault(ch, 0)) {
                    cntMap.put(ch, numMap.getOrDefault(ch, 0));
                }
            }
        }

        List<String> ans = new ArrayList<>();

        for (String a : A) {
            Map<Character, Integer> numMap = getNumMap(a);
            boolean okay = true;
            for (char ch : cntMap.keySet()) {
                if (numMap.getOrDefault(ch, 0) < cntMap.getOrDefault(ch, 0)) {
                    okay = false;
                    break;
                }
            }

            if (okay) ans.add(a);
        }


        return ans;
    }

    private Map<Character, Integer> getNumMap(String b) {
        Map<Character, Integer> ansMap = new HashMap<>();

        for (char ch : b.toCharArray()) {
            ansMap.put(ch, ansMap.getOrDefault(ch, 0) + 1);
        }

        return ansMap;
    }

}
