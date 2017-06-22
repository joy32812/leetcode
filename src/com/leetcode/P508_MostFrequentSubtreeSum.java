package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 22/06/2017.
 */
public class P508_MostFrequentSubtreeSum {

    private Map<Integer, Integer> cntMap = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {return new int[]{};}

        cntMap = new HashMap<>();

        work(root);

        int max = -1;
        for (int val : cntMap.values()) {
            max = Math.max(max, val);
        }
        List<Integer> list = new ArrayList<>();
        for (int key : cntMap.keySet()) {
            if (cntMap.get(key) == max) {
                list.add(key);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {ans[i] = list.get(i);}

        return ans;
    }

    private int work(TreeNode root) {
        if (root == null) {return 0;}
        if (root.left == null && root.right == null) {
            cntMap.put(root.val, cntMap.getOrDefault(root.val, 0) + 1);
            return root.val;
        }

        int a = work(root.left);
        int b = work(root.right);

        int key = a + b + root.val;

        cntMap.put(key, cntMap.getOrDefault(key, 0) + 1);
        return key;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(-3);

        t1.left = t2;
        t1.right = t3;

        System.out.println(new P508_MostFrequentSubtreeSum().findFrequentTreeSum(t1));
    }

}
