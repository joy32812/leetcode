package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyuan on 05/06/2017.
 */
public class P421_MaximumXORofTwoNumbersinanArray {

    public int findMaximumXOR(int[] nums) {

        int max = 0;
        int mask = 0;

        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);

            Set<Integer> set = new HashSet<>();
            for (int d : nums) {
                set.add(d & mask);
            }

            int tmp = max | (1 << i);
            for (int d : set) {
                if (set.contains(tmp ^ d)) {
                    max = tmp;
                    break;
                }
            }
        }

        return max;
    }

}
