package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaoyuan on 20/06/2017.
 */
public class P491_IncreasingSubsequences {

    private List<List<Integer>> ans;
    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new ArrayList<>();

        dfs(nums, 0, new ArrayList<Integer>());

        return ans;
    }

    private void dfs(int[] nums, int x, ArrayList<Integer> nowList) {
        if (nowList.size() >= 2) {
            ans.add(new ArrayList<>(nowList));
        }

        Set<Integer> uniqSet = new HashSet<>();

        for (int i = x; i < nums.length; i++) {
            if (nowList.size() > 0 && nums[i] < nowList.get(nowList.size() - 1)) {continue;}
            if (uniqSet.contains(nums[i])) {continue;}

            uniqSet.add(nums[i]);
            nowList.add(nums[i]);
            dfs(nums, i + 1, nowList);
            nowList.remove(nowList.size() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new P491_IncreasingSubsequences().findSubsequences(new int[]{4, 7, 7, 7}));
    }

}
