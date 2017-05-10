package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 10/05/2017.
 */
public class P350_IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> countOneMap = new HashMap<>();
        for (int d : nums1) {
            if (countOneMap.containsKey(d)) {
                countOneMap.put(d, countOneMap.get(d) + 1);
            } else {
                countOneMap.put(d, 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int d : nums2) {
            if (countOneMap.containsKey(d) && countOneMap.get(d) > 0) {
                ans.add(d);
                countOneMap.put(d, countOneMap.get(d) - 1);
            }
        }


        int[] result = new int[ans.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}
