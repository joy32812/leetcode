package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P822_CardFlippingGame {


    /**
     * should be easy
     * @param fronts
     * @param backs
     * @return
     */
    public int flipgame(int[] fronts, int[] backs) {

        int ans = Integer.MAX_VALUE;
        int n = fronts.length;

        Set<Integer> sameSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) sameSet.add(fronts[i]);
        }

        for (int i = 0; i < n; i++) {
            if (!sameSet.contains(fronts[i])) ans = Math.min(ans, fronts[i]);
            if (!sameSet.contains(backs[i])) ans = Math.min(ans, backs[i]);
        }


        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public static void main(String[] args) {
        System.out.println(new P822_CardFlippingGame().flipgame(new int[]{1, 2, 4, 4, 7}, new int[]{1, 3, 4, 1, 3}));
    }

}
