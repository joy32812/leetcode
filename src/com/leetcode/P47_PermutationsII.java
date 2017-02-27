package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyuan on 27/02/2017.
 * use next_permutation
 */
public class P47_PermutationsII {

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


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);

        addToResult(result, nums);

        while (hasNextPermutation(nums)) {
            nextPermutation(nums);
            addToResult(result, nums);
        }
        return result;
    }

    private void addToResult(List<List<Integer>> result, int[] nums) {
        List<Integer> oneAns = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            oneAns.add(nums[i]);
        }
        result.add(oneAns);
    }

    private boolean hasNextPermutation(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1};
        System.out.println(new P47_PermutationsII().permuteUnique(nums));
    }

}
