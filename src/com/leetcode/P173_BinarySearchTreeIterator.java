package com.leetcode;

import java.util.Stack;

/**
 * Created by xiaoyuan on 27/03/2017.
 */
public class P173_BinarySearchTreeIterator {
    private Stack<TreeNode> stack;
    private TreeNode currentNode;

    public P173_BinarySearchTreeIterator(TreeNode root) {
        if (root == null) {currentNode = null;return;}

        stack = new Stack<TreeNode>();
        while (true) {
            TreeNode leftNode = root.left;
            if (leftNode != null) {
                root.left = null;
                stack.add(root);
                root = leftNode;
            } else {
                break;
            }
        }

        currentNode = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return currentNode != null;
    }

    /** @return the next smallest number */
    public int next() {
        int ans = currentNode.val;
        TreeNode rightNode = currentNode.right;

        currentNode = rightNode;
        if (currentNode == null) {
            if (!stack.isEmpty()) {
                currentNode = stack.pop();
            }
        } else {
            while (true) {
                TreeNode leftNode = currentNode.left;
                if (leftNode != null) {
                    currentNode.left = null;
                    stack.add(currentNode);
                    currentNode = leftNode;
                } else {
                    break;
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(7);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(8);
        TreeNode t7 = new TreeNode(15);
        TreeNode t8 = new TreeNode(14);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;
        t3.right = t7;

        t7.left = t8;



        P173_BinarySearchTreeIterator obj = new P173_BinarySearchTreeIterator(t1);

        while (obj.hasNext()) {
            System.out.println(obj.next());
        }
    }


}
