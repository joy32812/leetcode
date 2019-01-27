package com.leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * use TreeMap floor
 */
class TimeMap {

    Map<String, TreeMap<Integer, String>> valMap;

    /** Initialize your data structure here. */
    public TimeMap() {
        valMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        valMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = valMap.computeIfAbsent(key, k -> new TreeMap<>());
        if (treeMap.size() == 0) return "";

        Map.Entry<Integer, String> integerStringEntry = treeMap.floorEntry(timestamp);
        if (integerStringEntry == null) return "";

        return integerStringEntry.getValue();
    }
}

public class P981_TimeBasedKeyValueStore {





    public static void main(String[] args) {

    }

}
