package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 25/06/2017.
 */
public class P525_ContiguousArray {

    public int findMaxLength(int[] nums) {

        int zero = 0;
        int one = 0;
        Map<Integer, Integer> posMap = new HashMap<>();
        posMap.put(0, -1);

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                zero++;
            } else {
                one++;
            }

            if (posMap.containsKey(zero - one)) {
                ans = Math.max(ans, i - posMap.get(zero - one));
            } else {
                posMap.put(zero - one, i);
            }
        }

        return ans;
    }

}
