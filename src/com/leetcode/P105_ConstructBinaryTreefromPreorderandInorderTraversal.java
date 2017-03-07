package com.leetcode;

/**
 * Created by xiaoyuan on 07/03/2017.
 */
public class P105_ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {return null;}
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if (preEnd < preBegin || inEnd < inBegin) {return null;}

        int nowVal = preorder[preBegin];

        int pos = 0;
        for (int i = inBegin; i <= inEnd; i++) {
            if (nowVal == inorder[i]) {
                pos = i;
                break;
            }
        }
        int leftSize = pos - inBegin;

        TreeNode nowNode = new TreeNode(nowVal);
        nowNode.left = dfs(preorder, preBegin + 1, preBegin + leftSize, inorder, inBegin, pos - 1);
        nowNode.right = dfs(preorder, preBegin + leftSize + 1, preEnd, inorder, pos + 1, inEnd);

        return nowNode;
    }

    public static void main(String[] args) {

    }

}
