package com.leetcode;

public class P889_ConstructBinaryTreefromPreorderandPostorderTraversal {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {

        return build(pre, 0, pre.length - 1, post, 0, post.length - 1);

    }

    private TreeNode build(int[] pre, int l, int r, int[] post, int s, int t) {
        if (l > r || s > t) return null;

        TreeNode root = new TreeNode(pre[l]);
        if (l == r) return root;

        int now = pre[l + 1];

        int idx = -1;
        for (int i = s; i <= t; i++) {
            if (post[i] == now)  {
                idx = i;
                break;
            }
        }

        int len = idx - s + 1;

        root.left = build(pre, l + 1, l + len, post, s, idx);
        root.right = build(pre, l + len + 1, r, post, idx + 1, t - 1);

        return root;
    }

}
