package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 25/02/2017.
 *
 * 暴力无限背包
 */
public class P39_CombinationSum {

    public List<List<Integer>> dfs(int[] candidates, int level, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (level >= candidates.length) {
            return result;
        }


        List<List<Integer>> sub = dfs(candidates, level + 1, target);
        if (sub.size() > 0) {
            result = sub;
        }

        int z = target;
        for (int i = 1; ; i++) {
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
                List<List<Integer>> lists = dfs(candidates, level + 1, z);
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

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return dfs(candidates, 0, target);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};

        List<List<Integer>> result = new P39_CombinationSum().combinationSum(nums, 7);
        System.out.println(result);
    }

}
