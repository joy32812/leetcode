package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 09/05/2017.
 */
public class P337_HouseRobberIII {


    public int rob(TreeNode root) {
        int[] val = dp(root);
        return Math.max(val[0], val[1]);
    }

    private int[] dp(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = dp(root.left);
        int[] right = dp(root.right);

        return new int[]{
                Math.max(left[0], left[1]) + Math.max(right[0], right[1]),
                root.val + left[0] + right[0]
        };
    }


}
