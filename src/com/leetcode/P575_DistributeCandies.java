package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P575_DistributeCandies {

    public int distributeCandies(int[] candies) {

        Set<Integer> kindSet = new HashSet<>();
        for (int d : candies) {kindSet.add(d);}

        return kindSet.size() <= candies.length / 2 ? kindSet.size() : candies.length / 2;

    }

}
