package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P1122_RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> posMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) posMap.put(arr2[i], i);

        List<Integer> ansList = Arrays.stream(arr1).boxed().collect(Collectors.toList());

        ansList.sort((a, b) -> {
            if (posMap.containsKey(a) && posMap.containsKey(b)) return posMap.get(a) - posMap.get(b);

            if (posMap.containsKey(a)) return -1;
            if (posMap.containsKey(b)) return 1;
            return a - b;
        });

        return ansList.stream().mapToInt(i -> i).toArray();
    }

}
