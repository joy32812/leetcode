package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaoyuan on 12/05/2017.
 */
public class P340_LongestSubstringwithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || k == 0) {return 0;}
        if (s.length() <= k) {return s.length();}

        int ans = 0;

        int i = -1;
        Map<Character, Integer> cntMap = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);

            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
            while (cntMap.size() > k) {
                i ++;
                char nowCh = s.charAt(i);
                cntMap.put(nowCh, cntMap.getOrDefault(nowCh, 0) - 1);
                if (cntMap.get(nowCh) == 0) cntMap.remove(nowCh);
            }

            ans = Math.max(ans, j - i);
        }

        return ans;
    }

}
