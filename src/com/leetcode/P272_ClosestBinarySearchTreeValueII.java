package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyuan on 17/04/2017.
 */
public class P272_ClosestBinarySearchTreeValueII {

    private LinkedList<Integer> linkedList;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        linkedList = new LinkedList<>();

        dfs(root, target, k);

        return linkedList;
    }

    private void dfs(TreeNode root, double target, int k) {
        if (root == null) {return;}

        dfs(root.left, target, k);
        linkedList.add(root.val);

        if (linkedList.size() > k) {
            int left = linkedList.getFirst();
            int right = linkedList.getLast();

            double diffA = Math.abs(left - target);
            double diffB = Math.abs(right - target);

            if (diffA < diffB) {
                linkedList.removeLast();

                if (root.val > target) {
                    return;
                }
            } else if (diffA == diffB){
                linkedList.removeLast();
                return;
            } else {
                linkedList.removeFirst();
            }
        }

        dfs(root.right, target, k);

    }

}
