package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 08/03/2017.
 */
public class P107_BinaryTreeLevelOrderTraversalII {

    private Map<Integer, List<Integer>> levelMap;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        levelMap = new HashMap<Integer, List<Integer>>();

        dfs(root, 1);

        int size = levelMap.keySet().size();
        for (int i = size; i >= 1; i--) {
            ans.add(levelMap.get(i));
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
