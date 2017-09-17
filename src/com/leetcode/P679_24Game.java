package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyuan on 17/09/2017.
 */
public class P679_24Game {

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int pos = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                pos = i;
            }
        }

        if (pos == -1) {
            Arrays.sort(nums);
            return;
        }

        int target = pos + 1;
        int diff = nums[target] - nums[pos];
        for (int i = pos + 2; i < nums.length; i++) {
            if (nums[i] - nums[pos] > 0 && nums[i] - nums[pos] < diff) {
                diff = nums[i] - nums[pos];
                target = i;
            }
        }

        swap(nums, pos, target);

        Arrays.sort(nums, pos + 1, nums.length);

    }

    public boolean judgePoint24(int[] nums) {

        for (int i = 0; i < 24; i++) {
            Set<Double> ans = getAll(nums, 0, 3);
            if (ans.contains(24.0)) {return true;}

            nextPermutation(nums);
        }


        return false;

    }

    private Set<Double> getAll(int[] nums, int l, int r) {
        if (l == r) {
            Set<Double> tmp = new HashSet<>();
            tmp.add(nums[r] + 0.0);
            return tmp;
        }

        Set<Double> ans = new HashSet<>();
        for (int i = l; i < r; i++) {
            Set<Double> left = getAll(nums, l, i);
            Set<Double> right = getAll(nums, i + 1, r);

            for (double x : left) {
                for (double y : right) {
                    ans.add(x + y);
                    ans.add(x - y);
                    ans.add(x * y);
                    if (y != 0 ) ans.add(x / y);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P679_24Game().judgePoint24(new int[]{1, 2, 1, 2}) );
        System.out.println(new P679_24Game().judgePoint24(new int[]{4, 1, 8, 7}) );
    }

}
