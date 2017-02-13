package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 12/02/2017.
 * 排序, 确定一个最小值, 双向遍历剩余部分, 往中间挤
 */
public class P_3Sum15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];

            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l + 1 < nums.length && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (r - 1 >= 0 && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println(new P_3Sum15().threeSum(nums));
    }

}
