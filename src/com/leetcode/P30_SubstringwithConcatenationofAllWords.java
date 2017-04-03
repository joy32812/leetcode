package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 03/04/2017.
 */
public class P30_SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String s, String[] words) {

        Map<String, Integer> countMap = new HashMap<String, Integer>();

        for (String word: words) {
            if (countMap.get(word) == null) {
                countMap.put(word, 1);
            } else {
                countMap.put(word, 1 + countMap.get(word));
            }
        }

        List<Integer> ans = new ArrayList<Integer>();

        int num = words.length;
        int len = words[0].length();

        for (int i = 0; i < s.length() - num * len + 1; i++) {
            Map<String, Integer> seenMap = new HashMap<String, Integer>();

            int j = 0;
            for (; j < num; j++) {
                String tmpWord = s.substring(i + j * len, i + j * len + len);
                if (seenMap.get(tmpWord) == null) {
                    seenMap.put(tmpWord, 1);
                } else {
                    seenMap.put(tmpWord, 1 + seenMap.get(tmpWord));
                }
                if (countMap.get(tmpWord) == null || seenMap.get(tmpWord) > countMap.get(tmpWord)) {
                    break;
                }
            }
            if (j == num) {
                ans.add(i);
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new P30_SubstringwithConcatenationofAllWords().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }

}
