package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 22/05/2017.
 */
public class P380_InsertDeleteGetRandom {


    public static void main(String[] args) {

        RandomizedSet obj = new RandomizedSet();

        obj.insert(0);
        obj.insert(1);

        obj.remove(0);

        obj.insert(2);

        obj.remove(1);

        System.out.println(obj.getRandom());

    }


}


class RandomizedSet {


    private Map<Integer, Integer> posMap;
    private List<Integer> array;
    private int total;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        posMap = new HashMap<>();
        array = new ArrayList<>();
        total = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (posMap.containsKey(val)) {return false;}

        if (total < array.size()) {
            array.set(total, val);
            posMap.put(val, total);
            total++;
        } else {
            array.add(val);
            posMap.put(val, total);
            total++;
        }
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!posMap.containsKey(val)) {return false;}

        int pos = posMap.get(val);
        if (pos != total - 1) {
            array.set(pos, array.get(total - 1));
            posMap.put(array.get(total - 1), pos);
        }

        posMap.remove(val);
        total--;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int idx = (int)(Math.random() * total);
        return array.get(idx);
    }


}