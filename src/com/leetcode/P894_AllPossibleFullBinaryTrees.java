package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P894_AllPossibleFullBinaryTrees {

    /**
     * easy
     * construct tree recursively
     * @param N
     * @return
     */
    public List<TreeNode> allPossibleFBT(int N) {

        List<TreeNode> ans = new ArrayList<>();

        if (N == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }

        for (int i = 1; i < N; i += 2) {
            int left = i;
            int right = N - left - 1;
            if (right % 2 == 0) continue;

            List<TreeNode> leftTrees = allPossibleFBT(left);
            List<TreeNode> rightTrees = allPossibleFBT(right);

            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {

                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;

                    ans.add(root);
                }
            }
        }

        return ans;
    }

}
