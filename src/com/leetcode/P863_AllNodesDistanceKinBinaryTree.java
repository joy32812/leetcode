package com.leetcode;

import java.util.*;

public class P863_AllNodesDistanceKinBinaryTree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        Map<TreeNode, TreeNode> fatherMap = new HashMap<>();
        dfs(root, null, fatherMap);


        Map<TreeNode, Integer> disMap = new HashMap<>();
        disMap.put(target, 0);

        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(target);
        Set<TreeNode> visit = new HashSet<>();
        visit.add(target);

        List<Integer> ans = new ArrayList<>();
        if (K == 0) {
            ans.add(target.val);
            return ans;
        }


        while (!Q.isEmpty()) {
            TreeNode now = Q.poll();

            TreeNode[] adj = new TreeNode[]{now.left, now.right, fatherMap.getOrDefault(now, null)};
            for (TreeNode to : adj) {
                if (to == null) continue;
                if (visit.contains(to)) continue;
                disMap.put(to, disMap.get(now) + 1);

                if (disMap.get(to) == K) {
                    ans.add(to.val);
                }

                visit.add(to);
                Q.add(to);
            }

        }


        return ans;
    }

    private void dfs(TreeNode root, TreeNode father, Map<TreeNode, TreeNode> fatherMap) {
        if (root == null) return;
        fatherMap.put(root, father);

        dfs(root.left, root, fatherMap);
        dfs(root.right, root, fatherMap);
    }

}
