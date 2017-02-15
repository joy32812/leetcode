package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyuan on 15/02/2017.
 * Just like 3sum
 * After sort, fix min two instead one
 * attention: remove the duplicate for i , j , l, r
 * O(n^3)
 */
public class P_4Sum18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int total = nums[i] + nums[j] + nums[l] + nums[r];
                    if (total == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l + 1 < nums.length && nums[l] == nums[l + 1]) {l++;}
                        while (r - 1 >= 0 && nums[r] == nums[r - 1]) {r--;}

                        l++;
                        r--;
                    } else if (total > target) {
                        r--;
                    } else {
                        l++;
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        System.out.println(new P_4Sum18().fourSum(nums, 0));
    }
}
