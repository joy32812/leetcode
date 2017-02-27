package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiaoyuan on 27/02/2017.
 * divide and conquer
 */
public class P46_Permutations {
    public List<List<Integer>> dfs(int[] nums,int idx) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (idx == nums.length - 1) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(nums[idx]);
            result.add(tmp);
            return result;
        }

        List<List<Integer>> others = dfs(nums, idx + 1);
        for (List<Integer> oneList : others) {
            for (int i = 0; i < oneList.size(); i++) {
                List<Integer> twoList = new ArrayList<Integer>(oneList);
                twoList.add(i, nums[idx]);
                result.add(twoList);
            }

            List<Integer> twoList = new ArrayList<Integer>(oneList);
            twoList.add(nums[idx]);
            result.add(twoList);
        }

        return result;
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        return dfs(nums, 0);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new P46_Permutations().permute(nums));
    }

}
