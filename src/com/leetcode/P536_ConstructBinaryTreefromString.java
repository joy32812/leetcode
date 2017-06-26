package com.leetcode;

import java.util.Stack;

/**
 * Created by xiaoyuan on 26/06/2017.
 */
public class P536_ConstructBinaryTreefromString {

    int[] pair;
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {return null;}

        pair = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')'){
                pair[stack.pop()] = i;
            }
        }

        return dfs(s, 0, s.length() - 1);

    }

    private TreeNode dfs(String s, int l, int r) {
        if (l > r) {return null;}

        TreeNode root = new TreeNode(0);

        int val = 0;
        int flag = 1;
        boolean hasChild = false;
        for (int i = l; i <= r; i++) {
            if (s.charAt(i) == '-') {
                flag = -1;
            } else if (s.charAt(i) == '(') {
                hasChild = true;
                root.val = flag * val;
                root.left = dfs(s, i + 1, pair[i] - 1);
                if (pair[i] + 1 < s.length()) {
                    root.right = dfs(s, pair[i] + 2, pair[pair[i] + 1] - 1);
                }
                break;
            } else {
                val = val * 10 + (s.charAt(i) - '0');
            }
        }

        if(!hasChild) {
            root.val = flag * val;
        }

        return root;
    }

    public static void main(String[] args) {
        System.out.println(new P536_ConstructBinaryTreefromString().str2tree("34(344)"));
//        System.out.println(new P536_ConstructBinaryTreefromString().str2tree("4(2(3)(1))(6(5))"));
    }

}
