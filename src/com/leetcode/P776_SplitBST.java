package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P776_SplitBST {



    public TreeNode[] splitBST(TreeNode root, int V) {

        TreeNode dummayLargeNode = new TreeNode(Integer.MAX_VALUE);
        TreeNode curLargeNode = dummayLargeNode;

        TreeNode dummaySmallNode = new TreeNode(Integer.MAX_VALUE);
        TreeNode curSmallNode = dummaySmallNode;


        while (root != null) {
            if (root.val > V) {
                if (curLargeNode.val > root.val) curLargeNode.left = root;
                else curLargeNode.right = root;
                curLargeNode = root;
                root = root.left;

                curLargeNode.left = null;
            } else {
                if (curSmallNode.val > root.val) curSmallNode.left = root;
                else curSmallNode.right = root;
                curSmallNode = root;
                root = root.right;

                curSmallNode.right = null;
            }
        }

        return new TreeNode[]{dummaySmallNode.left, dummayLargeNode.left};
    }



    List<TreeNode> smallList;
    List<TreeNode> bigList;
    public TreeNode[] splitBST2(TreeNode root, int V) {

        smallList = new ArrayList<>();
        bigList = new ArrayList<>();
        dfs(root, V, null);


        for (int i = smallList.size() - 1; i >= 1; i--) {
            rightMost(smallList.get(i - 1)).right = smallList.get(i);
        }
        for (int i = bigList.size() - 1; i >= 1; i--) {
            leftMost(bigList.get(i - 1)).left = bigList.get(i);
        }

        return new TreeNode[]{smallList.isEmpty() ? null : smallList.get(0), bigList.isEmpty() ? null : bigList.get(0)};
    }

    private TreeNode rightMost(TreeNode treeNode) {

        while (treeNode.right != null) treeNode = treeNode.right;
        return treeNode;
    }

    private TreeNode leftMost(TreeNode treeNode) {
        while (treeNode.left != null) treeNode = treeNode.left;
        return treeNode;
    }


    private void dfs(TreeNode root, int v, TreeNode father) {
        if (root == null) return;

        if (root.val > v) {
            if (father == null || father.val <= v) {
                if (father != null) father.right = null;
                bigList.add(root);
            }
            dfs(root.left, v, root);
        } else {
            if (father == null || father.val > v) {
                if (father != null) father.left = null;
                smallList.add(root);
            }
            dfs(root.right, v, root);
        }
    }

}
