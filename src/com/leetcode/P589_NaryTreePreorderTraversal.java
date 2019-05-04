package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P589_NaryTreePreorderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(Node root, List<Integer> ans) {
        if (root == null) return;

        ans.add(root.val);
        for (Node child : root.children) dfs(child, ans);
    }

}
