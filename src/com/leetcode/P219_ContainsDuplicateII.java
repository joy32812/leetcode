package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 04/04/2017.
 */
public class P219_ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P219_ContainsDuplicateII().containsNearbyDuplicate(new int[]{-1,-1}, 1));
    }

}
