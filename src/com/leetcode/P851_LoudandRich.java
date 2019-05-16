package com.leetcode;

import java.util.*;

public class P851_LoudandRich {

    public int[] loudAndRich(int[][] richer, int[] quiet) {

        int n = quiet.length;

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = i;


        int[] in = new int[n];
        Map<Integer, Set<Integer>> adjMap = new HashMap<>();
        for (int[] rich : richer) {
            adjMap.computeIfAbsent(rich[0], k -> new HashSet<>()).add(rich[1]);
            in[rich[1]]++;
        }

        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) Q.add(i);
        }


        while (!Q.isEmpty()) {
            int s = Q.poll();

            Set<Integer> adjSet = adjMap.computeIfAbsent(s, k -> new HashSet<>());
            for (int t : adjSet) {

                if (quiet[ans[t]] > quiet[ans[s]]) {
                    ans[t] = ans[s];
                }
                in[t]--;

                if (in[t] == 0) {
                    Q.add(t);
                }

            }

        }

        return ans;
    }

}
