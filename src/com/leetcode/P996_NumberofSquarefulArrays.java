package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P996_NumberofSquarefulArrays {

    int total;
    Map<Integer, Integer> cntMap;
    Map<Integer, Set<Integer>> adjMap;
    public int numSquarefulPerms(int[] A) {

        cntMap = new HashMap<>();
        adjMap = new HashMap<>();

        for (int v : A) {
            cntMap.put(v, cntMap.getOrDefault(v, 0) + 1);
        }

        for (int x : cntMap.keySet()) {
            for (int y : cntMap.keySet()) {
                if (isSquare(x, y)) {
                    adjMap.computeIfAbsent(x, k -> new HashSet<>()).add(y);
                    adjMap.computeIfAbsent(y, k -> new HashSet<>()).add(x);
                }
            }
        }

        total = 0;

        for (int x : cntMap.keySet()) {
            dfs(x, A.length - 1);
        }

        return total;
    }

    private void dfs(int x, int left) {
        cntMap.put(x, cntMap.getOrDefault(x, 0) - 1);
        if (left == 0) total++;

        for (int y : adjMap.getOrDefault(x, new HashSet<>())) {
            if (cntMap.get(y) > 0) dfs(y, left - 1);
        }

        cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
    }

    private boolean isSquare(int x, int y) {
        int sqrt = (int) Math.sqrt(0.0 + x + y);
        return (sqrt * sqrt) == (x + y);
    }

    public static void main(String[] args) {
        System.out.println(new P996_NumberofSquarefulArrays().numSquarefulPerms(new int[]{1, 17, 8}));
        System.out.println(new P996_NumberofSquarefulArrays().numSquarefulPerms(new int[]{0, 0, 0, 1, 1, 1}));
        System.out.println(new P996_NumberofSquarefulArrays().numSquarefulPerms(new int[]{2, 2, 2}));
        System.out.println(new P996_NumberofSquarefulArrays().numSquarefulPerms(new int[]{1}));
    }

}
