package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class P768_MaxChunksToMakeSortedII {

    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        List<Integer> data = Arrays.stream(arr).boxed().collect(Collectors.toList());
        data.sort(Comparator.comparingInt(a -> a));

        Map<Integer, Integer> posMap = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            if (!posMap.containsKey(data.get(i))) posMap.put(data.get(i), i);
        }

        int ans = 0;
        int max = -1;

        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, posMap.get(arr[i]) + cntMap.getOrDefault(arr[i], 0));
            if (max <= i) ans ++;

            cntMap.put(arr[i], cntMap.getOrDefault(arr[i], 0) + 1);
        }

        return ans;
    }

    public int maxChunksToSorted2(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int n = arr.length;
        int[] dp = new int[n];

        int min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = min;
            min = Math.min(min, arr[i]);
        }

        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);

            if (max <= dp[i]) ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P768_MaxChunksToMakeSortedII().maxChunksToSorted(new int[]{1, 1, 0, 0, 1}));
    }

}
