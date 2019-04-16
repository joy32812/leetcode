package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class P823_BinaryTreesWithFactors {

    Map<Integer, Long> resultMap;
    int MOD = (int) (1e9 + 7);

    /**
     * consider himself as a tree
     * @param A
     * @return
     */
    public int numFactoredBinaryTrees(int[] A) {

        resultMap = new HashMap<>();
        int n = A.length;

        Map<Integer, List<int[]>> prodMap = new HashMap<>();
        Set<Integer> intSet = Arrays.stream(A).boxed().collect(Collectors.toSet());

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long num = 1l * A[i] * A[j];
                if (num > 1000000000) continue;

                int intNum = (int)num;
                if (!intSet.contains(intNum)) continue;
                prodMap.computeIfAbsent(intNum, k -> new ArrayList<>()).add(new int[]{A[i], A[j]});
            }
        }

        long ans = 0;
        for (int d : A) {
            long num = dfs(d, prodMap);
            ans = (ans + num) % MOD;
        }

        return (int) ans;
    }

    private long dfs(int now, Map<Integer, List<int[]>> prodMap) {
        if (!prodMap.containsKey(now)) return 1l;
        if (resultMap.containsKey(now)) return resultMap.get(now);

        List<int[]> prodList = prodMap.get(now);
        long num = 0;
        for (int[] p : prodList) {
            int left = p[0];
            int right = p[1];

            if (left == right) num = (num + dfs(left, prodMap) * dfs(left, prodMap)) % MOD;
            else num = (num + 2 * dfs(left, prodMap) * dfs(right, prodMap)) % MOD;
        }

        num = (num + 1) % MOD;

        resultMap.put(now, num);
        return num;
    }

}
