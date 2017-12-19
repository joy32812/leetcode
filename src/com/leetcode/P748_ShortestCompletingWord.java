package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P748_ShortestCompletingWord {


    public String shortestCompletingWord(String licensePlate, String[] words) {

        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
            }
        }

        int len = Integer.MAX_VALUE;
        String ans = "";

        for (String w: words) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c: w.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            boolean okay = true;
            for (char ch : cntMap.keySet()) {
                int d = cntMap.get(ch);
                int z = map.getOrDefault(ch, 0);
                if (d > z) {
                    okay = false;
                    break;
                }
            }

            if (okay && len > w.length()) {
                len = w.length();
                ans = w;
            }
        }


        return ans;
    }


    public static void main(String[] args) {

        System.out.println(new P748_ShortestCompletingWord().shortestCompletingWord("1s3 PSt", new String[]{
                "step","steps","stripe","stepple"
        }));
    }

}
