package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 07/03/2017.
 */
public class P103_BinaryTreeZigzagLevelOrderTraversal {

    private Map<Integer, List<Integer>> levelMap;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        levelMap = new TreeMap<Integer, List<Integer>>();

        dfs(root, 1);

        for (Integer level: levelMap.keySet()) {
            if (level %2 == 0) {
                Collections.reverse(levelMap.get(level));
            }

            ans.add(levelMap.get(level));
        }

        return ans;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {return;}

        List<Integer> integers = levelMap.get(level);
        if (integers == null) {
            integers = new ArrayList<Integer>();
        }
        integers.add(root.val);

        levelMap.put(level, integers);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public static void main(String[] args) {

    }

}
