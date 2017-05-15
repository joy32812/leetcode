package com.leetcode;

import java.util.TreeMap;

/**
 * Created by xiaoyuan on 15/05/2017.
 */
public class P362_DesignHitCounter {

}

class HitCounter {

    TreeMap<Integer, Integer> map;
    int total;
    /** Initialize your data structure here. */
    public HitCounter() {
        total = 0;
        map = new TreeMap<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        total++;
        map.computeIfAbsent(timestamp, k -> 0);
        map.put(timestamp, map.get(timestamp) + 1);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!map.isEmpty()) {
            if (map.firstKey() + 300 <= timestamp) {
                total -= map.firstEntry().getValue();
                map.remove(map.firstKey());
            } else {
                break;
            }
        }

        return total;
    }
}