package com.leetcode;

public class P1008_ConstructBinarySearchTreefromPreorderTraversal {

    /**
     * easy, build recursively
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] order, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(order[l]);

        TreeNode now = new TreeNode(order[l]);
        int m = r + 1;
        for (int i = l + 1; i <= r; i++) {
            if (order[l] < order[i]) {
                m = i;
                break;
            }
        }

        now.left = build(order, l + 1, m - 1);
        now.right = build(order, m, r);

        return now;
    }


    public static void main(String[] args) {

    }

}
