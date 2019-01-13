package com.leetcode;


import java.util.ArrayList;
import java.util.List;

public class P971_FlipBinaryTreeToMatchPreorderTraversal {


    List<Integer> ansList;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {

        ansList = new ArrayList<>();
        dfs(root, voyage, 0, voyage.length - 1);

        if (ansList == null) {
            ansList = new ArrayList<>();
            ansList.add(-1);
        }

        return ansList;
    }

    private void dfs(TreeNode root, int[] voyage, int l, int r) {
        if ((root == null && l <= r) || (root != null && l > r)) {
            ansList = null;
            return;
        }
        if (root == null) return;

        if (root.val != voyage[l]) {
            ansList = null;
            return;
        }

        if (root.left == null) {
            dfs(root.right, voyage, l + 1, r);
        } else if (root.right == null) {
            dfs(root.left, voyage, l + 1, r);
        } else {
            int leftVal = root.left.val;
            int rightVal = root.right.val;

            if (voyage[l + 1] != leftVal && voyage[l + 1] != rightVal) {
                ansList = null;
                return;
            }

            if (voyage[l + 1] == leftVal) {
                int p = -1;
                for (int k = l + 2; k <= r; k++) {
                    if (voyage[k] == rightVal) {
                        p = k;
                        break;
                    }
                }

                if (p == -1) {
                    ansList = null;
                    return;
                }

                dfs(root.left, voyage, l + 1, p - 1);
                dfs(root.right, voyage, p, r);

            } else {

                if (ansList == null) return;

                ansList.add(root.val);

                int p = -1;
                for (int k = l + 2; k <= r; k++) {
                    if (voyage[k] == leftVal) {
                        p = k;
                        break;
                    }
                }

                if (p == -1) {
                    ansList = null;
                    return;
                }

                dfs(root.right, voyage, l + 1, p - 1);
                dfs(root.left, voyage, p, r);

            }
        }

    }


    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t2.left = t3;

        System.out.println(new P971_FlipBinaryTreeToMatchPreorderTraversal().flipMatchVoyage(t1, new int[]{1, 2, 3}));



    }

}
