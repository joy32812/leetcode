package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 28/04/2017.
 */
public class P314_BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Map<Integer, List<Integer>> ansMap = new HashMap<>();

        Map<TreeNode, Integer> colMap = new HashMap<>();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        colMap.put(root, 0);
        ansMap.computeIfAbsent(0, k -> new ArrayList<>()).add(root.val);

        int from = 0;
        int to = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                TreeNode now = Q.poll();

                if (now.left != null) {
                    int col = colMap.get(now) - 1;
                    from = Math.min(from, col);
                    colMap.put(now.left, col);
                    ansMap.computeIfAbsent(col, k -> new ArrayList<>()).add(now.left.val);
                    Q.add(now.left);
                }

                if (now.right != null) {
                    int col = colMap.get(now) + 1;
                    to = Math.max(to, col);

                    colMap.put(now.right, col);
                    ansMap.computeIfAbsent(col, k -> new ArrayList<>()).add(now.right.val);
                    Q.add(now.right);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = from; i <= to; i++) ans.add(ansMap.get(i));
        return ans;
    }


}
