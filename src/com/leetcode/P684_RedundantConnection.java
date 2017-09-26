package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaoyuan on 24/09/2017.
 */
public class P684_RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {

        for (int i = edges.length - 1; i >= 0; i--) {
            if (okay(i, edges)) {
                return edges[i];
            }
        }

        return new int[]{};
    }

    private boolean okay(int x, int[][] edges) {

        Map<Integer, Integer> father = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (i == x) continue;

            int a = edges[i][0];
            int b = edges[i][1];

            int fatherA = getFather(a, father);
            int fatherB = getFather(b, father);

            if (fatherB == fatherA) return false;
            father.put(fatherB, fatherA);
        }

        Set<Integer> fatherSet = new HashSet<>();
        for (int d : father.keySet()) {
            fatherSet.add(getFather(d, father));
        }

        return fatherSet.size() == 1;
    }

    private int getFather(int x, Map<Integer, Integer> father) {
        while (father.containsKey(x) && father.get(x) != x) {
            x = father.get(x);
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(new P684_RedundantConnection().findRedundantConnection(new int[][]{
                {5, 2},
                {3, 4},
                {4, 3},
                {5, 3},
                {1, 3},
        }));
    }

}
