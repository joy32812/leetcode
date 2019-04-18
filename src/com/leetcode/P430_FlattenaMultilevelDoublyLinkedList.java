package com.leetcode;



public class P430_FlattenaMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };

    /**
     * recursive
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        return dfs(head)[0];

    }

    private Node[] dfs(Node head) {
        if (head == null) return new Node[]{head, head};

        Node[] ans = new Node[]{head, head};

        Node next = head.next;
        Node child = head.child;

        head.next = null;
        head.child = null;

        if (child != null) {
            Node[] nodes = dfs(child);

            ans[1].next = nodes[0];
            nodes[0].prev = ans[1];

            ans[1] = nodes[1];
        }

        if (next != null) {
            Node[] nodes = dfs(next);

            ans[1].next = nodes[0];
            nodes[0].prev = ans[1];


            ans[1] = nodes[1];
        }

        return ans;
    }

}
