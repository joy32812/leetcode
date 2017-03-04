package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 02/03/2017.
 */
public class P78_Subsets {


    public void dfs(List<List<Integer>> result, boolean[] visit, int[] nums, int pos, int num, int k) {
        if (num == k) {
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < visit.length; i++) {
                if(visit[i]) {
                    tmp.add(nums[i]);
                }
            }
            result.add(tmp);
            return;
        }

        if (num >= visit.length) {
            return;
        }

        if (num + visit.length - pos < k) {
            return;
        }

        visit[pos] = false;
        dfs(result, visit, nums, pos + 1, num, k);

        visit[pos] = true;
        dfs(result, visit, nums, pos + 1, num + 1, k);
        visit[pos] = false;
    }

    public void combine(List<List<Integer>> result, int[] nums,  int n, int k) {
        boolean[] visit = new boolean[n];
        dfs(result,visit, nums, 0, 0, k);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i <= nums.length; i++) {
            combine(result, nums, nums.length, i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new P78_Subsets().subsets(nums));
    }

}
