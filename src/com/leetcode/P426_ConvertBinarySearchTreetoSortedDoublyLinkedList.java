package com.leetcode;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class P426_ConvertBinarySearchTreetoSortedDoublyLinkedList {

    /**
     * recursive
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        return dfs(root)[0];
    }

    private Node[] dfs(Node root) {
        Node[] ans = new Node[]{root, root};

        Node left = root.left;
        Node right = root.right;

        root.left = root;
        root.right = root;


        if (left != null) {
            Node[] ns = dfs(left);

            ns[1].right = ans[0];
            ans[0].left = ns[1];

            ans[1].right = ns[0];
            ns[0].left = ans[1];

            ans[0] = ns[0];
        }

        if (right != null) {
            Node[] ns = dfs(right);

            ans[1].right = ns[0];
            ns[0].left = ans[1];


            ns[1].right = ans[0];
            ans[0].left = ns[1];

            ans[1] = ns[1];
        }

        return ans;
    }

}
