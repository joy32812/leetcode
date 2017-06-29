package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaoyuan on 29/06/2017.
 * [1,null,2,3,4]
 */
public class P545_BoundaryofBinaryTree {

    List<TreeNode> leafList;
    Set<TreeNode> inSet;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        leafList = new ArrayList<>();

        inSet = new HashSet<>();
        dfs(root, 0);

        List<Integer> ans = new ArrayList<>();

        TreeNode now = root;
        while (now != null) {
            inSet.add(now);
            ans.add(now.val);

            if (now.left == null && now == root) {
                break;
            }
            if (now.left != null) {
                now = now.left;
            } else {
                now = now.right;
            }
        }
        for (int i = 0; i < leafList.size(); i++) {
            if (!inSet.contains(leafList.get(i))) {
                inSet.add(leafList.get(i));
                ans.add(leafList.get(i).val);
            }
        }

        List<TreeNode> rightList = new ArrayList<>();
        now = root;
        while (now != null) {
            rightList.add(now);

            if (now.right == null && now == root) {
                break;
            }

            if (now.right != null) {
                now = now.right;
            } else {
                now = now.left;
            }
        }

        for (int i = rightList.size() - 1; i >= 0; i--) {
            if (!inSet.contains(rightList.get(i))) {
                ans.add(rightList.get(i).val);
            }
        }
        return ans;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {return;}

        if (root.left == null && root.right == null) {
            leafList.add(root);
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);

    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t1.right = t2;

        t2.left = t3;
        t2.right = t4;

        System.out.println(new P545_BoundaryofBinaryTree().boundaryOfBinaryTree(t1));
    }

}
