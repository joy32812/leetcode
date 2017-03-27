package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 27/03/2017.
 */
public class P170_TwoSumIII_Datastructuredesign {

    private Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public P170_TwoSumIII_Datastructuredesign() {
        map = new HashMap<Integer, Integer>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (map.get(number) == null) {
            map.put(number, 1);
        } else {
            map.put(number, 1 + map.get(number));
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int key : map.keySet()) {
            int other = value - key;
            int num = map.get(key);
            if (key == other) {
                if(num >= 2) {return true;}
            } else {
                if(map.keySet().contains(other)) {return true;}
            }
        }

        return false;
    }

    public static void main(String[] args) {
        P170_TwoSumIII_Datastructuredesign obj = new P170_TwoSumIII_Datastructuredesign();

        obj.add(0);
        obj.add(-1);
        obj.add(1);
        System.out.println(obj.find(0));
    }

}
