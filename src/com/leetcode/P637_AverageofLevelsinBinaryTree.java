package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 28/07/2017.
 */
public class P637_AverageofLevelsinBinaryTree {

    Map<Integer, Long> sumMap;
    Map<Integer, Long> cntMap;
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {return new ArrayList<>();}

        sumMap = new HashMap<>();
        cntMap = new HashMap<>();

        dfs(root, 1);

        List<Double> ans = new ArrayList<>();
        int size = sumMap.size();
        for (int i = 1; i <= size; i++) {
            ans.add((sumMap.get(i) + 0.0) / cntMap.get(i));
        }

        return ans;
    }

    private void dfs(TreeNode root, int d) {
        if (root == null) {return;}
        sumMap.put(d, sumMap.getOrDefault(d, 0L) + root.val);
        cntMap.put(d, cntMap.getOrDefault(d, 0L) + 1);

        dfs(root.left, d + 1);
        dfs(root.right, d + 1);
    }

}
