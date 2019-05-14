package com.leetcode;

import java.util.*;

public class P1042_FlowerPlantingWithNoAdjacent {

    int[] ans;
    public int[] gardenNoAdj(int N, int[][] paths) {
        ans = new int[N];
        Arrays.fill(ans, -1);

        Map<Integer, Set<Integer>> adjMap = new HashMap<>();
        for (int[] p : paths) {
            adjMap.computeIfAbsent(p[0] - 1, k -> new HashSet<>()).add(p[1] - 1);
            adjMap.computeIfAbsent(p[1] - 1, k -> new HashSet<>()).add(p[0] - 1);
        }

        for (int i = 0; i < N; i++) {
            if (ans[i] == -1) dfs(i, adjMap);
        }

        return ans;
    }

    private void dfs(int x, Map<Integer, Set<Integer>> adjMap) {
        Set<Integer> colorSet = new HashSet<>();
        Set<Integer> adjSet = adjMap.computeIfAbsent(x, k -> new HashSet<>());
        for (int y : adjSet) {
            if (ans[y] != -1) colorSet.add(ans[y]);
        }

        for (int i = 1; i <= 4; i++) {
            if (!colorSet.contains(i)) {
                ans[x] = i;
                break;
            }
        }

        for (int y : adjSet) {
            if (ans[y] == -1) dfs(y, adjMap);
        }

    }

    public static void main(String[] args) {
        System.out.println(new P1042_FlowerPlantingWithNoAdjacent().gardenNoAdj(4, new int[][]{
                {1, 2},
                {3, 4},
                {3, 2},
                {4, 2},
                {4, 1}
        }));
    }

}
