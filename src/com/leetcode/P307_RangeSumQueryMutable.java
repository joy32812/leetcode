package com.leetcode;

/**
 * Created by xiaoyuan on 26/04/2017.
 */
public class P307_RangeSumQueryMutable {

    private class SGNode {
        int sum;
        SGNode left, right;
        int l, r;

        public SGNode(int l, int r, int sum) {
            this.l = l;
            this.r = r;
            this.sum = sum;
        }
    }

    private SGNode root;
    private int[] data;

    private SGNode buildTree(int l, int r, int[] nums) {
        if (l > r) {return null;}

        SGNode now = new SGNode(l, r, nums[l]);
        if (l == r) {return now;}

        int m = (l + r) / 2;
        now.left = buildTree(l, m, nums);
        now.right = buildTree(m + 1, r, nums);

        now.sum = (now.left == null ? 0 : now.left.sum) + (now.right == null ? 0 : now.right.sum);
        return now;
    }

    private void updateTree(SGNode root, int l, int r, int pos, int val) {
        if (l == r && l == pos) {
            root.sum = val;
            return;
        }

        int m = (l + r) / 2;
        if (pos <= m) {
            updateTree(root.left, l, m, pos, val);
        } else {
            updateTree(root.right, m + 1, r, pos, val);
        }

        root.sum = (root.left == null ? 0 : root.left.sum) + (root.right == null ? 0 : root.right.sum);
    }

    private int getSum(SGNode root, int l, int r) {
        if (root.l == l && root.r == r) {
            return root.sum;
        }

        int m = (root.l + root.r) / 2;
        if (m < l) {
            return getSum(root.right, l, r);
        } else if (m < r) {
            return getSum(root.left, l, m) + getSum(root.right, m + 1, r);
        } else {
            return getSum(root.left, l, r);
        }
    }

    public P307_RangeSumQueryMutable(int[] nums) {
        data = nums;
        root = buildTree(0, nums.length - 1, nums);
    }

    public void update(int i, int val) {
        updateTree(root, 0, data.length - 1, i, val);
    }

    public int sumRange(int i, int j) {
        return getSum(root, i, j);
    }

    public static void main(String[] args) {
        P307_RangeSumQueryMutable obj = new P307_RangeSumQueryMutable(new int[]{0, 9, 5, 7, 3});

        System.out.println(obj.sumRange(4, 4));
        System.out.println(obj.sumRange(2, 4));
        System.out.println(obj.sumRange(3, 3));
    }

}
