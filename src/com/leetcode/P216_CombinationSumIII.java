package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 03/04/2017.
 */
public class P216_CombinationSumIII {

    private List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<List<Integer>>();
        dfs(k, n , 1, new ArrayList<Integer>());

        return ans;
    }

    private void dfs(int k, int n, int start, ArrayList<Integer> integers) {

        if (n < 0) {
            return;
        }
        if (integers.size() == k && n == 0) {
            List<Integer> list = new ArrayList<Integer>(integers);
            ans.add(list);
            return;
        }

        for (int i = start; i<= 9; i++) {
            integers.add(i);
            dfs(k, n - i, i + 1, integers);
            integers.remove(integers.size() - 1);
        }

    }


    public static void main(String[] args) {
        System.out.println(new P216_CombinationSumIII().combinationSum3(3, 7));
    }

}
