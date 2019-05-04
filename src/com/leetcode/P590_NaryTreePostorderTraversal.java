package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P590_NaryTreePostorderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();

        dfs(root, ans);

        return ans;
    }

    private void dfs(Node root, List<Integer> ans) {
        if (root == null) return;

        for (Node child : root.children) dfs(child, ans);
        ans.add(root.val);
    }

}
