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
        int cnt;

        public NodeWrapper(TreeNode father, TreeNode now, boolean isLeft, int cnt) {
            this.father = father;
            this.now = now;
            this.isLeft = isLeft;
            this.cnt = cnt;
        }
    }

    private int globleCnt;

    List<NodeWrapper> nodeWrappers;
    private NodeWrapper lastOne;

    private void dfs(TreeNode root, TreeNode father, boolean isLeft) {
        if (root.left != null) {
            dfs(root.left, root, true);
        }

        int nowCnt = globleCnt++;
        if (lastOne != null) {
            if (lastOne.now.val > root.val) {
                nodeWrappers.add(lastOne);
                nodeWrappers.add(new NodeWrapper(father, root, isLeft, nowCnt));
            }
        }
        lastOne = new NodeWrapper(father, root, isLeft, nowCnt);

        if (root.right != null) {
            dfs(root.right, root, false);
        }
    }

    public void recoverTree(TreeNode root) {
        nodeWrappers = new ArrayList<NodeWrapper>();
        globleCnt = 0;
        dfs(root, null, false);

        for (NodeWrapper nodeWrapper: nodeWrappers) {
            System.out.println(nodeWrapper.now.val + "  " + nodeWrapper.isLeft + "  " + nodeWrapper.cnt);
        }

        if (nodeWrappers.size() == 2) {
            swap(nodeWrappers.get(0), nodeWrappers.get(1));
        } else {
            swap(nodeWrappers.get(0), nodeWrappers.get(3));
        }
    }

    private void swap(NodeWrapper aa, NodeWrapper bb) {
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
