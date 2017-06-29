package com.leetcode;

/**
 * Created by xiaoyuan on 29/06/2017.
 */
public class P549_BinaryTreeLongestConsecutiveSequenceII {

    private int ans;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {return 0;}

        ans = 0;

        work(root);

        return ans;
    }

    // 0 increase
    // 1 decrease
    private int[] work(TreeNode root) {
        int[] res = new int[]{1, 1};

        if (root.left != null) {
            int[] childAns = work(root.left);
            if (root.val + 1 == root.left.val) {
                res[0] = Math.max(res[0], 1 + childAns[0]);
            } else if (root.val - 1 == root.left.val) {
                res[1] = Math.max(res[1], 1 + childAns[1]);
            }
        }

        if (root.right != null) {
            int[] childAns = work(root.right);
            if (root.val + 1 == root.right.val) {
                res[0] = Math.max(res[0], 1 + childAns[0]);
            } else if (root.val - 1 == root.right.val) {
                res[1] = Math.max(res[1], 1 + childAns[1]);
            }
        }
        ans = Math.max(ans, res[0] + res[1] - 1);

        return res;
    }

}
