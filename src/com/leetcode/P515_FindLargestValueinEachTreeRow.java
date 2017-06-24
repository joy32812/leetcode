package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 24/06/2017.
 */
public class P515_FindLargestValueinEachTreeRow {

    private Map<Integer, Integer> ansMap;
    public List<Integer> largestValues(TreeNode root) {

        ansMap = new HashMap<>();
        work(root, 0);

        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < ansMap.size();i++) {
            ansList.add(ansMap.get(i));
        }
        return ansList;
    }

    private void work(TreeNode root, int d) {
        if (root == null) {return;}

        if (!ansMap.containsKey(d)) {ansMap.put(d, root.val);}
        else {
            ansMap.put(d, Math.max(ansMap.get(d), root.val));
        }

        work(root.left, d + 1);
        work(root.right, d + 1);
    }

    public static void main(String[] args) {
    }

}
