package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 21/04/2017.
 */
public class P294_FlipGameII {

    private Map<String, Boolean> ansMap;
    public boolean canWin(String s) {
        if (ansMap == null) {ansMap = new HashMap<>();}
        return dfs(s);
    }

    private boolean dfs(String s) {
        if (ansMap.containsKey(s)) {return ansMap.get(s);}

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                String w = s.substring(0, i - 1) + "--" + s.substring(i + 1);
                if (!dfs(w)) {
                    ansMap.put(s, true);
                    return true;
                }
            }
        }

        return false;
    }

}
