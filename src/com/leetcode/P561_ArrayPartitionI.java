package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 30/06/2017.
 */
public class P561_ArrayPartitionI {


    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }

        return ans;
    }

}
