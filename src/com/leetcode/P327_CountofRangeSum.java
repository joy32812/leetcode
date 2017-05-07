package com.leetcode;

/**
 * Created by xiaoyuan on 07/05/2017.
 */
public class P327_CountofRangeSum {

    private class BSTNode {
        long val;
        int cnt;
        int childNum;
        BSTNode left,right;

        public BSTNode(long val, int cnt, int childNum) {
            this.val = val;
            this.cnt = cnt;
            this.childNum = childNum;
        }
    }

    private BSTNode root;

    public int countRangeSum(int[] nums, int lower, int upper) {
        root = null;

        long total = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];

            if (total >= lower && total <= upper) {ans++;}

            if (root != null) {
                ans += find(root, total - upper, total - lower, Long.MIN_VALUE, Long.MAX_VALUE);
            }

            if (root == null) {
                root = new BSTNode(total, 1, 0);
            } else {
                insert(root, total);
            }
        }

        return ans;
    }

    private int find(BSTNode root, long lower, long upper, long minValue, long maxValue) {
        if (root == null) {
            return 0;
        }

        if (minValue >= lower && maxValue <= upper) {
            return root.cnt + root.childNum;
        }

        if (root.val < lower) {
            return find(root.right, lower, upper, root.val + 1, maxValue);
        } else if (root.val >= lower && root.val <= upper) {
            return root.cnt + find(root.left, lower, upper, minValue, root.val - 1) + find(root.right, lower, upper, root.val + 1, maxValue);
        } else {
            return find(root.left, lower, upper, minValue, root.val - 1);
        }
    }


    private BSTNode insert(BSTNode root, long x) {
        if (root == null) {
            root = new BSTNode(x, 1, 0);
            return root;
        }

        if (root.val < x) {
            root.right = insert(root.right, x);
            root.childNum = (root.left != null ? root.left.childNum + root.left.cnt : 0) + (root.right != null ? root.right.childNum + root.right.cnt : 0);
        } else if (root.val == x) {
            root.cnt ++;
        } else {
            root.left = insert(root.left, x);
            root.childNum = (root.left != null ? root.left.childNum + root.left.cnt : 0) + (root.right != null ? root.right.childNum + root.right.cnt : 0);
        }

        return root;
    }

    public static void main(String[] args) {
        System.out.println(new P327_CountofRangeSum().countRangeSum(new int[]{-2147483647,0,-2147483647,2147483647}, -564, 3864));
//        System.out.println(new P327_CountofRangeSum().countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }

}
