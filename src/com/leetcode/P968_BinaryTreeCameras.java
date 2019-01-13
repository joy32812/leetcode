package com.leetcode;

public class P968_BinaryTreeCameras {


    public int minCameraCover(TreeNode root) {

        int[] ans = dfs(root);
        return Math.min(ans[0], getBuJia(ans));
    }

    private int[] dfs(TreeNode root) {

        if (root.left == null && root.right == null) {
            return new int[]{1, 0, -1};
        }

        if (root.left == null) {
            int[] right = dfs(root.right);

            int[] ans = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 1};
            ans[0] = 1 + right[0];
            ans[0] = Math.min(ans[0], 1 + right[1]);

            ans[1] = right[0];
            if (getBuJia(right) < ans[1]) {
                ans[1] = getBuJia(right);
                ans[2] = -1;
            }

            return ans;
        }

        if (root.right == null) {
            int[] left = dfs(root.left);

            int[] ans = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 1};
            ans[0] = 1 + left[0];
            ans[0] = Math.min(ans[0], 1 + left[1]);

            ans[1] = left[0];
            if (getBuJia(left) < ans[1]) {
                ans[1] = getBuJia(left);
                ans[2] = -1;
            }

            return ans;
        }


        int[] ans = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 1};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        ans[0] = 1 + Math.min(left[0], left[1]) + Math.min(right[0], right[1]);

        ans[1] = left[0] + right[0];

        if (left[0] + getBuJia(right) < ans[1]) {
            ans[1] = left[0] + getBuJia(right);
        }
        if (getBuJia(left) + right[0] < ans[1]) {
            ans[1] = getBuJia(left) + right[0];
        }

        if (ans[1] > getBuJia(left) + getBuJia(right)) {
            ans[1] = getBuJia(left) + getBuJia(right);
            ans[2] = -1;
        }

        return ans;
    }

    private int getBuJia(int[] now) {
        if (now[2] < 0) return now[1] + 1;
        return now[1];
    }


    private int[] dfs2(TreeNode root) {

        if (root.left == null && root.right == null) {
            return new int[]{1, 0};
        }

        int[] left = new int[]{0, 1};
        int[] right = new int[]{0, 1};
        int[] ans = new int[]{0, 0};

        if (root.left != null) left = dfs(root.left);
        if (root.right != null) right = dfs(root.right);


        ans[0] = 1 + Math.min(left[0], left[1]) + Math.min(right[0], right[1]);

        ans[1] = Integer.MAX_VALUE;
        ans[1] = Math.min(ans[1], left[0] + right[1]);
        ans[1] = Math.min(ans[1], left[1] + right[0]);
        ans[1] = Math.min(ans[1], left[1] + right[1]);

        return ans;
    }


    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t1.left = t2;

        t2.left = t3;
        t2.left = t4;

        System.out.println(new P968_BinaryTreeCameras().minCameraCover(t1));

    }

}
