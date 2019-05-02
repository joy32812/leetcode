package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P886_PossibleBipartition {

    public boolean possibleBipartition(int N, int[][] dislikes) {

        Map<Integer, Integer> fatherMap = new HashMap<>();
        Map<Integer, Set<Integer>> dislikeMap = new HashMap<>();
        for (int[] dis : dislikes) {
            dislikeMap.computeIfAbsent(dis[0], k -> new HashSet<>()).add(dis[1]);
            dislikeMap.computeIfAbsent(dis[1], k -> new HashSet<>()).add(dis[0]);
        }


        for (int people : dislikeMap.keySet()) {
            int fa = getFather(people, fatherMap);

            int dislikeFather = -people;
            for (int t : dislikeMap.get(people)) {
                int ft = getFather(t, fatherMap);
                if (fa == ft) return false;

                fatherMap.put(ft, dislikeFather);
            }
        }

        return true;
    }

    private int getFather(int people, Map<Integer, Integer> fatherMap) {
        if (!fatherMap.containsKey(people)) fatherMap.put(people, people);
        if (fatherMap.get(people) == people) return people;

        int fa = getFather(fatherMap.get(people), fatherMap);
        fatherMap.put(people, fa);
        return fa;
    }

}
