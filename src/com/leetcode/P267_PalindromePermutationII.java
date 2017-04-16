package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 16/04/2017.
 */
public class P267_PalindromePermutationII {

    private List<String> ans;
    private Character midChar;
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> numMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (numMap.get(ch) == null) {
                numMap.put(ch, 1);
            } else {
                numMap.put(ch, numMap.get(ch) + 1);
            }
        }
        int oddsNum = s.length() % 2;
        midChar = null;
        for (Character key : numMap.keySet()) {
            int num = numMap.get(key);
            if (num % 2 == 1) {
                numMap.put(key, num - 1);
                midChar = key;
                oddsNum--;
            }
            if (oddsNum < 0) {return new ArrayList<>();}
        }


        ans = new ArrayList<>();

        dfs(numMap, "");

        return ans;
    }

    private void dfs(Map<Character, Integer> numMap, String now) {
        boolean empty = true;
        for (Character key : numMap.keySet()) {
            int num = numMap.get(key);
            if (num != 0) {empty = false;}
        }

        if (empty) {
            ans.add(now + (midChar == null ? "" : midChar) + new StringBuilder(now).reverse().toString());
            return;
        }

        for (Character key : numMap.keySet()) {
            int num = numMap.get(key);
            if (num == 0) {continue;}
            numMap.put(key, num - 2);

            dfs(numMap, now + key);

            numMap.put(key, num);
        }
    }

    public static void main(String[] args) {
        System.out.println(new P267_PalindromePermutationII().generatePalindromes("abc"));
    }

}
