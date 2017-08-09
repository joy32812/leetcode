package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 09/08/2017.
 */
public class P655_PrintBinaryTree {

    List<List<String>> ans;
    public List<List<String>> printTree(TreeNode root) {

        int h = getHeight(root);

        int m = h;
        int n = (1 << h) - 1;

        ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<String> tmp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                tmp.add("");
            }
            ans.add(tmp);
        }

        dfs(root, 0, n - 1, 0);

        return ans;
    }

    private void dfs(TreeNode root, int l, int r, int depth) {
        if (root == null) {return;}

        int mid = (l + r) / 2;
        ans.get(depth).set(mid, "" + root.val);

        dfs(root.left, l, mid - 1, depth + 1);
        dfs(root.right, mid + 1, r, depth + 1);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {return 0;}
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}
