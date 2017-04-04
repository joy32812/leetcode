package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 04/04/2017.
 */
public class P220_ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> treeSet = new TreeSet<Long>();

        for (int i = 0; i < nums.length; i++) {
            Long floor = treeSet.floor(0L + nums[i] + t);
            Long ceil = treeSet.ceiling(0L + nums[i] - t);

            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) {
                return true;
            }
            treeSet.add(0L + nums[i]);

            if (i >= k) {
                treeSet.remove(0L + nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P220_ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{-2147483648,-2147483647}, 3, 3));
    }

}
