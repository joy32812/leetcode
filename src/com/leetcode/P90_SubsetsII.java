package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 05/03/2017.
 *
 * brute search
 * use cnt array to track the num that used
 */
public class P90_SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Map<Integer, Integer> cntMap = new HashMap<Integer, Integer>();
        for (int v : nums) {
            if (cntMap.get(v) == null) {
                cntMap.put(v, 1);
            } else {
                cntMap.put(v, cntMap.get(v) + 1);
            }
        }

        int size = cntMap.size();
        int[] values = new int[size];
        int[] cnts = new int[size];
        int[] used = new int[size];

        int id = 0;
        for(int key : cntMap.keySet()) {
            int value = cntMap.get(key);
            values[id] = key;
            cnts[id] = value;
            id++;
        }


        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i <= nums.length; i++) {
            dfs(values, cnts, used, 0, 0, i, ans);
        }

        return ans;
    }

    private void dfs(int[] values, int[] cnts, int[] used, int pos, int now, int total, List<List<Integer>> ans) {
        if (now == total) {
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < used.length; i++) {
                for (int j = 0; j < used[i]; j++) {
                    tmp.add(values[i]);
                }
            }
            ans.add(tmp);
            return;
        }

        if (pos >= values.length) {
            return;
        }

        for (int i = 0; i <= cnts[pos] && now + i <= total; i++) {
            used[pos] = i;
            dfs(values, cnts, used, pos + 1, now + i, total, ans);
            used[pos] = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P90_SubsetsII().subsetsWithDup(new int[]{1, 2, 2}));
    }

}
