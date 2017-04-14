package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 14/04/2017.
 */
public class P257_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {return new ArrayList<>();}

        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);

        List<String> ans = new ArrayList<>();
        for (String s : left) {
            ans.add(root.val + "->" + s);
        }
        for (String s : right) {
            ans.add(root.val + "->" + s);
        }

        if (left.size() == 0 && right.size() == 0) {
            ans.add("" + root.val);
        }

        return ans;
    }

}
