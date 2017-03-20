package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiaoyuan on 20/03/2017.
 */
public class P144_BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (true) {
            if (root == null && stack.isEmpty()) {break;}
            if (root == null) {
                root = stack.pop();
            }

            result.add(root.val);

            if(root.left == null) {
                root = root.right;
            } else {
                if (root.right != null) {
                    stack.add(root.right);
                }
                root = root.left;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t4;
        t2.right = t3;
        t4.left = t5;

        System.out.println(new P144_BinaryTreePreorderTraversal().preorderTraversal(t1));
    }

}
