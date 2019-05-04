package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P429_NaryTreeLevelOrderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;

        Queue<Node> Q = new LinkedList<>();
        Q.add(root);

        while (!Q.isEmpty()) {
            int len = Q.size();
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Node now = Q.poll();
                result.add(now.val);

                for (Node child : now.children) {
                    if (child != null) Q.add(child);
                }
            }

            ans.add(result);
        }

        return ans;
    }

}
