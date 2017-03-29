package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaoyuan on 29/03/2017.
 * just traverse the binary tree
 */
public class P199_BinaryTreeRightSideView {

    private Set<Integer> levelSet;
    private List<Integer> ans;

    public void traverse(TreeNode root, int level) {
        if (root == null) {return;}
        if (!levelSet.contains(level)) {
            levelSet.add(level);
            ans.add(root.val);
        }
        traverse(root.right, level + 1);
        traverse(root.left, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        levelSet = new HashSet<Integer>();
        ans = new ArrayList<Integer>();
        traverse(root, 1);
        return ans;
    }

}
