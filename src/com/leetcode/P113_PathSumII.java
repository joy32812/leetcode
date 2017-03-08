package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiaoyuan on 08/03/2017.
 */
public class P113_PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<Integer> used = new Stack<Integer>();

        dfs(root, used, 0, sum, result);

        return result;
    }

    private void dfs(TreeNode root, Stack<Integer> used, int total, int sum, List<List<Integer>> result) {
        if (root == null) {return;}

        if (root.left == null && root.right == null) {
            if (total + root.val == sum) {
                List<Integer> tmp = new ArrayList<Integer>();
                for (int v : used) {tmp.add(v);}

                tmp.add(root.val);
                result.add(tmp);
            }
            return;
        }

        used.push(root.val);
        dfs(root.left, used, total + root.val, sum, result);
        dfs(root.right, used, total + root.val, sum, result);
        used.pop();
    }


    public static void main(String[] args) {

    }

}
