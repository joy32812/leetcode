package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaoyuan on 01/08/2017.
 */
public class P501_FindModeinBinarySearchTree {

    int nowCnt;
    int maxCnt;
    int last;

    Set<Integer> ans;
    public int[] findMode(TreeNode root) {

        ans = new HashSet<>();

        nowCnt = 0;
        maxCnt = 0;
        last = Integer.MIN_VALUE;

        dfs(root);


        nowCnt = 0;
        last = Integer.MIN_VALUE;
        work(root);


        int[] res = new int[ans.size()];
        int i = 0;
        for (int d : ans) {
            res[i++] = d;
        }

        return res;
    }

    private void work(TreeNode root) {
        if (root == null) {
            return;
        }
        work(root.left);
        if (last == root.val) {
            nowCnt++;
        } else {
            nowCnt = 1;
        }
        last = root.val;
        if (nowCnt == maxCnt) {
            ans.add(root.val);
        }

        work(root.right);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (last == root.val) {
            nowCnt++;
        } else {
            nowCnt = 1;
        }
        last = root.val;
        maxCnt = Math.max(maxCnt, nowCnt);

        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
//        TreeNode t3 = new TreeNode(2);
//        TreeNode t4 = new TreeNode(2);
//        TreeNode t5 = new TreeNode(3);

        t1.left = t2;

//        t1.right = t2;
//        t2.left = t3;

//        t1.left = t2;
//        t1.right = t3;
//
//        t3.left = t4;
//        t3.right = t5;

        System.out.println(new P501_FindModeinBinarySearchTree().findMode(t1));
    }

}
