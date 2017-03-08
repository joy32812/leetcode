package com.leetcode;

/**
 * Created by xiaoyuan on 08/03/2017.
 */
public class P108_ConvertSortedArraytoBinarySearchTree {
    public TreeNode creatTree(int [] nums, int l, int r) {
        if (l > r) {return null;}
        int mid = (l + r) / 2;
        TreeNode now = new TreeNode(nums[mid]);
        now.left = creatTree(nums, l, mid - 1);
        now.right = creatTree(nums, mid + 1, r);

        return now;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return creatTree(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
    }
}
