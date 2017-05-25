package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 25/05/2017.
 */
public class P395_LongestSubstringwithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        return work(s, 0, s.length() - 1, k);
    }

    private int work(String s, int l, int r, int k) {
        if (r - l + 1 < k) {return 0;}

        int[] cnt = new int[26];
        for (int i = l; i <= r; i++ ){
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0 || cnt[i] >= k) {continue;}

            for (int j = l; j <=r ; j++) {
                if (s.charAt(j) - 'a' == i) {
                    return Math.max(work(s, l, j - 1, k), work(s, j + 1, r, k));
                }
            }
        }

        return r - l + 1;
    }

    public static void main(String[] args) {
        System.out.println(new P395_LongestSubstringwithAtLeastKRepeatingCharacters().longestSubstring("ababacb", 3));
        System.out.println(new P395_LongestSubstringwithAtLeastKRepeatingCharacters().longestSubstring("aaabbb", 3));
        System.out.println(new P395_LongestSubstringwithAtLeastKRepeatingCharacters().longestSubstring("ababbc", 2));
        System.out.println(new P395_LongestSubstringwithAtLeastKRepeatingCharacters().longestSubstring("aaabb", 3));
    }

}
