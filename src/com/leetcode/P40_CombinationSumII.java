package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyuan on 25/02/2017.
 * P39的变形
 * 每个值只能使用一次
 * 需要排序并计算一下重复的个数.
 *
 */
public class P40_CombinationSumII {

    public List<List<Integer>> dfs(int[] candidates, int level, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (level >= candidates.length) {
            return result;
        }

        int count = 1;
        for (int i = level + 1; i < candidates.length; i++) {
            if (candidates[i] == candidates[level]) {
                count ++;
            } else {
                break;
            }
        }

        List<List<Integer>> sub = dfs(candidates, level + count, target);
        if (sub.size() > 0) {
            result = sub;
        }

        int z = target;
        for (int i = 1; i <= count; i++) {
            z -= candidates[level];
            if (z < 0) {
                break;
            } else if (z == 0) {
                List<Integer> tmp = new ArrayList<Integer>();
                for (int j = 1; j <= i; j++) {
                    tmp.add(candidates[level]);
                }
                result.add(tmp);
            } else {
                List<List<Integer>> lists = dfs(candidates, level + count, z);
                for(List<Integer> tmp: lists) {
                    for (int j = 1; j <= i; j++) {
                        tmp.add(candidates[level]);
                    }
                    result.add(tmp);
                }
            }
        }

        return result;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return dfs(candidates, 0, target);
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};

        System.out.println(new P40_CombinationSumII().combinationSum2(nums, 8));
    }
}
