package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P997_FindtheTownJudge {

    /**
     * easy, use map to record number
     * @param N
     * @param trust
     * @return
     */
    public int findJudge(int N, int[][] trust) {

        Map<Integer, Set<Integer>> trustMap = new HashMap<>();

        Map<Integer, Set<Integer>> beingMap = new HashMap<>();

        for (int[] t : trust) {
            trustMap.computeIfAbsent(t[0], k -> new HashSet<>()).add(t[1]);
            beingMap.computeIfAbsent(t[1], k -> new HashSet<>()).add(t[0]);
        }

        int ans = -1;
        for (int i = 1; i <= N; i++) {
            if (trustMap.computeIfAbsent(i, k -> new HashSet<>()).isEmpty() && beingMap.computeIfAbsent(i, k -> new HashSet<>()).size() == N - 1) {
                if (ans != -1) return -1;
                ans = i;
            }
        }


        return ans;
    }


    public static void main(String[] args) {

    }

}
