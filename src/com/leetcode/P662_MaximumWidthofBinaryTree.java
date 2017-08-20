package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 20/08/2017.
 */
public class P662_MaximumWidthofBinaryTree {

    Map<Integer, Integer> minMap;
    Map<Integer, Integer> maxMap;
    public int widthOfBinaryTree(TreeNode root) {

        minMap = new HashMap<>();
        maxMap = new HashMap<>();

        int h = getHeight(root);
//        int w = 1 << (h - 1);

        work(root, 1, 1);

        int ans = 0;
        for (int i = 1; i <= h; i++) {
            ans = Math.max(ans, maxMap.get(i) - minMap.get(i) + 1);
        }

        return ans;
    }

    private void work(TreeNode root, int x, int depth) {
        if (root == null) {return;}

        minMap.put(depth, Math.min(minMap.getOrDefault(depth, Integer.MAX_VALUE), x));
        maxMap.put(depth, Math.max(maxMap.getOrDefault(depth, Integer.MIN_VALUE), x));

        work(root.left, 2 * x - 1, depth + 1);
        work(root.right, 2 * x, depth + 1);

    }


    private int getHeight(TreeNode root) {
        if (root == null) {return 0;}

        return Math.max(getHeight(root.left), + getHeight(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(9);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;

        t3.right = t5;




        System.out.println(new P662_MaximumWidthofBinaryTree().widthOfBinaryTree(t1));
    }

}
