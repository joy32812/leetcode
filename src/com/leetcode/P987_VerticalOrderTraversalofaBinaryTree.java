package com.leetcode;

import java.util.*;

public class P987_VerticalOrderTraversalofaBinaryTree {


    public List<List<Integer>> verticalTraversal(TreeNode root) {

        Map<Integer, List<int[]>> orderMap = new TreeMap<>();
        dfs(root, orderMap, 0, 0);

        List<List<Integer>> ans = new ArrayList<>();
        for (int x : orderMap.keySet()) {

            List<int[]> valList = orderMap.getOrDefault(x, new ArrayList<>());
            Collections.sort(valList, (a, b) -> {
                if (a[0] == b[0] && a[1] == b[1]) return a[2] - b[2];

                if (a[0] == b[0]) return b[1] - a[1];
                return a[0] - b[0];
            });

            List<Integer> nowList = new ArrayList<>();
            for (int[] aa : valList) {
                nowList.add(aa[2]);
            }
            ans.add(nowList);
        }

        return ans;
    }

    private void dfs(TreeNode root, Map<Integer, List<int[]>> orderMap, int x, int y) {

        if (root == null) return;
        orderMap.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[]{x, y, root.val});

        dfs(root.left, orderMap, x - 1, y - 1);
        dfs(root.right, orderMap, x + 1, y - 1);
    }

    public static void main(String[] args) {
    }


}
