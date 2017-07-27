package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyuan on 27/07/2017.
 */
public class P645_SetMismatch {

    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int x = -1;
        for (int d : nums) {
            if (set.contains(d)) {
                x = d;
            }
            set.add(d);
        }

        int y = -1;
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                y = i;
                break;
            }
        }

        return new int[]{x, y};
    }

}
