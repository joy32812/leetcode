package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 06/03/2017.
 */
public class P99_RecoverBinarySearchTree {

    class NodeWrapper {
        TreeNode father;
        TreeNode now;
        boolean isLeft;

        public NodeWrapper(TreeNode father, TreeNode now, boolean isLeft) {
            this.father = father;
            this.now = now;
            this.isLeft = isLeft;
        }
    }

    List<NodeWrapper> nodeWrappers;
    private NodeWrapper lastOne;

    private void dfs(TreeNode root, TreeNode father, boolean isLeft) {
        if (root.left != null) {
            dfs(root.left, root, true);
        }

        if (lastOne != null) {
            if (lastOne.now.val > root.val) {
                nodeWrappers.add(lastOne);
            }
        }
        lastOne = new NodeWrapper(father, root, isLeft);

        if (root.right != null) {
            dfs(root.right, root, false);
        }
    }

    public void recoverTree(TreeNode root) {
        nodeWrappers = new ArrayList<NodeWrapper>();
        dfs(root, null, false);

        for (NodeWrapper nodeWrapper: nodeWrappers) {
            System.out.println(nodeWrapper.now.val);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(15);
        TreeNode t3 = new TreeNode(9);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(12);
        TreeNode t7 = new TreeNode(17);
        TreeNode t8 = new TreeNode(10);
        TreeNode t9 = new TreeNode(13);

        t1.left = t2;
        t1.right = t3;

        t3.left = t4;
        t3.right = t5;

        t5.left = t6;
        t5.right = t7;

        t6.left = t8;
        t6.right = t9;

        new P99_RecoverBinarySearchTree().recoverTree(t1);

        // FIXME  not finished
        // TODO


    }
}
