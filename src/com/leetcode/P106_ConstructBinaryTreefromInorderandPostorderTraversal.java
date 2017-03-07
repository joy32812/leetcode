package com.leetcode;

/**
 * Created by xiaoyuan on 07/03/2017.
 */
public class P106_ConstructBinaryTreefromInorderandPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {return null;}
        return dfs(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] postorder, int postBegin, int postEnd, int[] inorder, int inBegin, int inEnd) {
        if (postEnd < postBegin || inEnd < inBegin) {return null;}

        int nowVal = postorder[postEnd];

        int pos = 0;
        for (int i = inBegin; i <= inEnd; i++) {
            if (nowVal == inorder[i]) {
                pos = i;
                break;
            }
        }
        int leftSize = pos - inBegin;

        TreeNode nowNode = new TreeNode(nowVal);
        nowNode.left = dfs(postorder, postBegin, postBegin + leftSize - 1, inorder, inBegin, pos - 1);
        nowNode.right = dfs(postorder, postBegin + leftSize, postEnd - 1, inorder, pos + 1, inEnd);

        return nowNode;
    }

    public static void main(String[] args) {

    }

}
