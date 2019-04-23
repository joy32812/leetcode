package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class P833_FindAndReplaceinString {

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (S == null || S.length() == 0) return S;

        Map<Integer, String[]> repMap = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            int ind = indexes[i];
            repMap.put(ind, new String[]{sources[i], targets[i]});
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (!repMap.containsKey(i)) {
                sb.append(S.charAt(i));
                continue;
            }

            String s = repMap.get(i)[0];
            String t = repMap.get(i)[1];

            if (i + s.length() <= S.length() && S.substring(i, i + s.length()).equals(s)) {
                sb.append(t);
                i = i + s.length() - 1;
            } else {
                sb.append(S.charAt(i));
            }
        }

        return sb.toString();
    }

}
