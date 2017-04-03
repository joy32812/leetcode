package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyuan on 03/04/2017.
 */
public class P217_ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int d : nums) {
            if (set.contains(d)) {return true;}
            set.add(d);
        }

        return false;
    }

}
