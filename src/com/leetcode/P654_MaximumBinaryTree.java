package com.leetcode;

/**
 * Created by xiaoyuan on 09/08/2017.
 */
public class P654_MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        return work(nums, 0, nums.length - 1);
    }

    private TreeNode work(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new TreeNode(nums[l]);
        }

        int max = Integer.MIN_VALUE;
        int p = -1;
        for (int i = l; i <= r; i++) {
            if (max < nums[i]) {
                max = nums[i];
                p = i;
            }
        }

        TreeNode now = new TreeNode(nums[p]);

        now.left = work(nums, l, p - 1);
        now.right = work(nums, p + 1, r);

        return now;
    }

}
