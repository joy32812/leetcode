package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaoyuan on 10/05/2017.
 */
public class P349_IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> oneSet = new HashSet<>();
        for (int d : nums1) {oneSet.add(d);}

        List<Integer> ans = new ArrayList<>();
        Set<Integer> twoSet = new HashSet<>();
        for (int d : nums2) {
            if (twoSet.contains(d)) {continue;}
            twoSet.add(d);

            if (oneSet.contains(d)) {
                ans.add(d);
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

}
