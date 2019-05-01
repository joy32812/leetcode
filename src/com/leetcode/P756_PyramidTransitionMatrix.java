package com.leetcode;

import java.util.*;

public class P756_PyramidTransitionMatrix {

    Map<String, Set<String>> allowMap;

    /**
     * back tracing
     * + memo
     * @param bottom
     * @param allowed
     * @return
     */
    public boolean pyramidTransition(String bottom, List<String> allowed) {

        allowMap = new HashMap<>();
        for (String aw : allowed) {
            String key = aw.substring(0, 2);
            String val = aw.substring(2);
            allowMap.computeIfAbsent(key, k -> new HashSet<>()).add(val);
        }

        Set<String> result = dfs(bottom);
        return result.size() > 0;
    }

    private Set<String> dfs(String bottom) {
        if (bottom.length() <= 2) return allowMap.getOrDefault(bottom, new HashSet<>());
        if (allowMap.containsKey(bottom)) return allowMap.get(bottom);

        Set<String> ans = new HashSet<>();

        Set<String> first = allowMap.getOrDefault(bottom.substring(0, 2), new HashSet<>());
        if (first.size() == 0) {
            allowMap.put(bottom, ans);
            return allowMap.get(bottom);
        }

        Set<String> other = dfs(bottom.substring(1));

        for (String s : first) {
            for (String t : other) {
                if (allowMap.containsKey(s + t)) {
                    ans.addAll(allowMap.get(s + t));
                }
            }
        }

        allowMap.put(bottom, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P756_PyramidTransitionMatrix().pyramidTransition("XYZ", Arrays.asList("XYD", "YZE", "DEA", "FFF")));
    }

}
