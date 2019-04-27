package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P428_SerializeandDeserializeNaryTree {

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
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            if (root == null) return "";

            StringBuilder sb = new StringBuilder();
            sb.append("(" + root.val);
            if (root.children != null) {
                for (Node child : root.children) sb.append(serialize(child));
            }
            sb.append(")");

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if (data == null || data.length() == 0) return null;

            int val = 0;
            int i = 1;
            for (; i < data.length(); i++) {
                char ch = data.charAt(i);
                if (!Character.isDigit(ch)) break;
                val = val * 10 + (ch - '0');
            }

            Node root = new Node(val, new ArrayList<>());

            int begin = i;
            int diff = 0;
            for (; i < data.length(); i++) {
                char ch = data.charAt(i);
                if (ch == '(') diff ++;
                else if (ch == ')') diff --;
                if (diff == 0) {
                    root.children.add(deserialize(data.substring(begin, i + 1)));
                    begin = i + 1;
                }
            }

            return root;
        }
    }

    public static void main(String[] args) {
        new P428_SerializeandDeserializeNaryTree().work();
    }

    private void work() {
        Codec cc = new Codec();

        Node n1 = new Node(1, new ArrayList<>());
        Node n2 = new Node(3, new ArrayList<>());
        Node n3 = new Node(2, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());
        Node n5 = new Node(5, new ArrayList<>());
        Node n6 = new Node(6, new ArrayList<>());

        n1.children.addAll(Arrays.asList(n2, n3, n4));
        n2.children.addAll(Arrays.asList(n5, n6));
        System.out.println(cc.serialize(n1));

        Node ans = cc.deserialize(cc.serialize(n1));
        System.out.println(ans);
    }

}
