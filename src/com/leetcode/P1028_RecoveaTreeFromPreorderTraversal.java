package com.leetcode;

import java.util.LinkedList;

public class P1028_RecoveaTreeFromPreorderTraversal {



    public TreeNode recoverFromPreorder(String S) {
        LinkedList<int[]> nodeList = new LinkedList<>();

        int i = 0;
        while (i < S.length()) {
            int num = 0;
            while (i < S.length() && S.charAt(i) == '-') {
                num++;
                i++;
            }
            int val = 0;
            while (i < S.length() && S.charAt(i) != '-') {
                val = val * 10 + (S.charAt(i) - '0');
                i++;
            }
            nodeList.add(new int[]{num, val});
        }

        return build(nodeList, 0, 0, nodeList.size() - 1);
    }

    private TreeNode build(LinkedList<int[]> nodeList, int depth, int l, int r) {
        if (l > r) return null;

        TreeNode root = new TreeNode(nodeList.get(l)[1]);

        int begin = -1;
        for (int i = l; i <=r; i++) {
            if (nodeList.get(i)[0] == depth + 1) {
                begin = i;
                break;
            }
        }

        if (begin == -1) return root;

        int start = -1;
        for (int i = begin + 1; i <= r; i++) {
            if (nodeList.get(i)[0] == depth + 1) {
                start = i;
                break;
            }
        }

        root.left = build(nodeList, depth + 1, begin, start == -1 ? r : start - 1);
        if (start != -1) root.right = build(nodeList, depth + 1, start, r);


        return root;
    }


    public static void main(String[] args) {
        System.out.println(new P1028_RecoveaTreeFromPreorderTraversal().recoverFromPreorder("1-401--349---90--88"));
    }

}
