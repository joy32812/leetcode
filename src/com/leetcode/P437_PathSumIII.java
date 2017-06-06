package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 06/06/2017.
 */
public class P437_PathSumIII {

    private int ans;
    private int SUM;
    public int pathSum(TreeNode root, int sum) {


        SUM = sum;
        ans = 0;
        dfs(root);

        return ans;
    }

    private Map<Integer, Integer> dfs(TreeNode root) {
        if (root == null) {return new HashMap<>();}

        Map<Integer, Integer> res = new HashMap<>();
        Map<Integer, Integer> leftMap = dfs(root.left);
        Map<Integer, Integer> rightMap = dfs(root.right);

        res.put(root.val, 1);
        for (int key : leftMap.keySet()) {
            int nowKey = key + root.val;
            res.put(nowKey, leftMap.get(key) + (res.containsKey(nowKey) ? res.get(nowKey) : 0));
        }
        for (int key : rightMap.keySet()) {
            int nowKey = key + root.val;
            res.put(nowKey, rightMap.get(key) + (res.containsKey(nowKey) ? res.get(nowKey) : 0));
        }

        ans += (res.containsKey(SUM) ? res.get(SUM) : 0);


        return res;
    }

}
