package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiaoyuan on 06/03/2017.
 *
 */

public class P94_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode now = root;

        while (true) {
            if (now == null) {
                if (stack.isEmpty()) {
                    break;
                }

                now = stack.pop();
                result.add(now.val);
                now = now.right;
            } else if (now.left != null) {
                stack.push(now);
                now = now.left;
            } else if (now.right != null) {
                result.add(now.val);
                now = now.right;
            } else {
                result.add(now.val);
                now = null;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // 1
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t3.left = t1;
        t3.right = t2;

        // 2
//        TreeNode t1 = new TreeNode(1);

        System.out.println(new P94_BinaryTreeInorderTraversal().inorderTraversal(t3));
    }

}
