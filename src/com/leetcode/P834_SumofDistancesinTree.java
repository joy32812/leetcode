package com.leetcode;

import java.util.*;

public class P834_SumofDistancesinTree {


    class TreeNode {
        int val;

        int num;
        int sum;

        TreeNode father;
        List<TreeNode> children;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    Map<Integer, Set<Integer>> adjMap;
    int[] ans;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (N <= 0) return null;

        ans = new int[N];
        adjMap = new HashMap<>();
        for (int[] edge : edges) {
            adjMap.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            adjMap.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }

        TreeNode root = build(0, null);

        getAns(root, N);

        return ans;
    }

    private void getAns(TreeNode root, int N) {

        if (root.father == null) {
            ans[root.val] = root.sum;
        } else {
            ans[root.val] = root.sum + ans[root.father.val] - root.sum - root.num + (N - root.num);
        }

        for (TreeNode child : root.children) {
            getAns(child, N);
        }

    }

    private TreeNode build(int x, TreeNode father) {
        TreeNode root = new TreeNode(x);
        root.father = father;

        Set<Integer> adjSet = adjMap.computeIfAbsent(x, k -> new HashSet<>());

        List<TreeNode> children = new ArrayList<>();
        for (int y : adjSet) {
            if (father != null && father.val == y) continue;

            children.add(build(y, root));
        }

        root.children = children;
        root.num = 1;
        for (TreeNode child: children) {
            root.num += child.num;
            root.sum += child.sum + child.num;
        }

        return root;
    }


}
