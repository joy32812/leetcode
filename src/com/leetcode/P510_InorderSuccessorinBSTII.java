package com.leetcode;

public class P510_InorderSuccessorinBSTII {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
    public Node inorderSuccessor(Node x) {
        if (x.right == null) {
            if (x.parent == null) return null;
            if (x.parent.left == x) return x.parent;

            x.parent.right = null;
            return inorderSuccessor(x.parent);
        }

        return leftMost(x.right);
    }

    private Node leftMost(Node node) {
        if (node.left == null) return node;
        return leftMost(node.left);
    }

}
