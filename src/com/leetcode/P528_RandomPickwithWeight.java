package com.leetcode;

import java.util.Random;
import java.util.TreeMap;

public class P528_RandomPickwithWeight {

    TreeMap<Integer, Integer> treeMap;
    int sum;


    /**
     * TreeMap ceiling and floor
     * very useful
     * @param w
     */
    public P528_RandomPickwithWeight(int[] w) {
        treeMap = new TreeMap<>();

        sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            treeMap.put(sum, i);
        }
    }

    public int pickIndex() {
        int random = new Random().nextInt(sum) + 1;
        return treeMap.ceilingEntry(random).getValue();
    }

}
