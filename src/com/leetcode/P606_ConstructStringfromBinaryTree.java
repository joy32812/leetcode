package com.leetcode;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P606_ConstructStringfromBinaryTree {

    public String tree2str(TreeNode t) {
        if (t == null) {return "";}

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (left.length() == 0 && right.length() == 0) return "" + t.val;
        else if (left.length() == 0) return "" + t.val + "()" + "(" + right + ")";
        else if (right.length() == 0) return "" + t.val + "(" + left + ")";
        else return "" + t.val + "(" + left + ")" + "(" + right + ")";
    }

}
