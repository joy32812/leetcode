package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P846_HandofStraights {

    public boolean isNStraightHand(int[] hand, int W) {

        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int d : hand) cntMap.put(d, cntMap.getOrDefault(d, 0) + 1);

        for (int d : hand) {
            if (cntMap.getOrDefault(d, 0) == 0) continue;
            if (cntMap.getOrDefault(d - 1, 0) > 0) continue;

            for (int i = d; i < d + W; i++) {
                if (cntMap.getOrDefault(i, 0) == 0) return false;
                cntMap.put(i, cntMap.get(i) - 1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P846_HandofStraights().isNStraightHand(new int[]{
                1,2,3,6,2,3,4,7,8
        }, 3));
    }


}
