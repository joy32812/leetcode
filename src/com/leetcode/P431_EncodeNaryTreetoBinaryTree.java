package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P431_EncodeNaryTreetoBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    class Codec {

        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if (root == null) return null;

            List<Node> children = new ArrayList<>();
            children.add(root);

            return doEncode(children, 0);
        }

        private TreeNode doEncode(List<Node> nodes, int i) {
            if (nodes == null || i >= nodes.size()) return null;
            Node now = nodes.get(i);

            TreeNode ans = new TreeNode(now.val);
            ans.left = doEncode(now.children, 0);
            ans.right = doEncode(nodes, i + 1);

            return ans;
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if (root == null) return null;

            List<Node> ansList = doDecode(root);
            return ansList.get(0);
        }

        private List<Node> doDecode(TreeNode root) {
            List<Node> ansList = new ArrayList<>();
            if (root == null) return ansList;

            Node now = new Node(root.val, new ArrayList<>());
            List<Node> left = doDecode(root.left);
            List<Node> right = doDecode(root.right);

            ansList.add(now);
            ansList.addAll(right);

            now.children = left;
            return ansList;
        }

    }

}
