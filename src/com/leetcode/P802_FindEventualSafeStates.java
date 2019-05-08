package com.leetcode;

import java.util.*;

public class P802_FindEventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        if (graph == null || graph.length == 0) return null;

        List<Integer> ans = new ArrayList<>();
        int n = graph.length;

        Map<Integer, Set<Integer>> adjMap = new HashMap<>();
        int[] inDegree = new int[n];

        for (int s = 0; s < n; s ++) {
            for (int t : graph[s]) {
                adjMap.computeIfAbsent(t, k -> new HashSet<>()).add(s);
                inDegree[s]++;
            }
        }


        // topological sort
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) Q.add(i);
        }

        while (!Q.isEmpty()) {
            int s = Q.poll();
            ans.add(s);

            Set<Integer> adjSet = adjMap.computeIfAbsent(s, k -> new HashSet<>());
            for (int t : adjSet) {
                inDegree[t] --;
                if (inDegree[t] == 0) {
                    Q.add(t);
                }
            }
        }

        ans.sort(Comparator.comparingInt(a -> a));

        return ans;
    }

}
