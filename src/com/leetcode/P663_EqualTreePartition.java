package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaoyuan on 20/08/2017.
 */
public class P663_EqualTreePartition {

    List<Long> sumList;
    public boolean checkEqualTree(TreeNode root) {

        sumList = new ArrayList<>();
        long sum = work(root);

        for (int i = 0; i < sumList.size() - 1; i ++) {
            long d = sumList.get(i);
            if (d * 2 == sum) {return true;}
        }
        return false;
    }

    private long work(TreeNode root) {
        if (root == null) {return 0;}

        long total = work(root.left) + work(root.right) + root.val;
        sumList.add(total);
        return total;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(0);
        System.out.println(new P663_EqualTreePartition().checkEqualTree(t1));
    }

}
