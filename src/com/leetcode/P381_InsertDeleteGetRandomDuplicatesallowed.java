package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 22/05/2017.
 */
public class P381_InsertDeleteGetRandomDuplicatesallowed {

    public static void main(String[] args) {
        RandomizedCollection obj = new RandomizedCollection();

        System.out.println(obj.insert(0));
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(-1));
        System.out.println(obj.remove(0));
    }

}



class RandomizedCollection {


    private Map<Integer, Set<Integer>> posMap;
    private List<Integer> array;
    private int total;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        posMap = new HashMap<>();
        array = new ArrayList<>();
        total = 0;
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ans = !posMap.containsKey(val);

        if (total < array.size()) {
            array.set(total, val);
        } else {
            array.add(val);
        }

        posMap.computeIfAbsent(val, k -> new HashSet<>()).add(total);
        total++;

        return ans;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (posMap.computeIfAbsent(val, k -> new HashSet<>()).size() == 0) {return false;}

        Set<Integer> set = posMap.get(val);

        Iterator<Integer> iterator = set.iterator();
        int idx = iterator.next();

        posMap.computeIfAbsent(val, k -> new HashSet<Integer>()).remove(idx);

        if (idx != total - 1) {
            int lastVal = array.get(total - 1);
            array.set(idx, lastVal);

            posMap.computeIfAbsent(lastVal, k -> new HashSet<Integer>()).remove(total - 1);
            posMap.computeIfAbsent(lastVal, k -> new HashSet<Integer>()).add(idx);
        }

        total--;

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int idx = (int)(Math.random() * total);
        return array.get(idx);
    }

}