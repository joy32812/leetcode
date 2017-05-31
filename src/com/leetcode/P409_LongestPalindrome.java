package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 31/05/2017.
 */
public class P409_LongestPalindrome {

    public int longestPalindrome(String s) {

        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            cntMap.computeIfAbsent(ch, k -> 0);
            cntMap.put(ch, cntMap.get(ch) + 1);
        }

        boolean odd = true;

        int ans = 0;
        for (char ch : cntMap.keySet()) {
            int d = cntMap.get(ch);

            ans += (d / 2) * 2;
            if (d % 2 == 0 || odd == false) {continue;}

            odd = false;
            ans ++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P409_LongestPalindrome().longestPalindrome("abccccdd"));
    }

}
