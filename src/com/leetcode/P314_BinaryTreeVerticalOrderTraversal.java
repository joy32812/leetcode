package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 28/04/2017.
 */
public class P314_BinaryTreeVerticalOrderTraversal {

    private int cnt;
    private class DataNode {
        int cnt;
        int val;
        int deepth;

        public DataNode(int val, int deepth,int cnt) {
            this.val = val;
            this.deepth = deepth;
            this.cnt = cnt;
        }
    }

    private Map<Integer, List<DataNode>> ansMap;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        cnt = 0;
        ansMap = new TreeMap<>();
        work(root, 0, 0);

        List<List<Integer>> ansList = new ArrayList<>();
        for (List<DataNode> list : ansMap.values()){
            list.sort((a, b) -> {
                if (a.deepth == b.deepth) {
                    return a.cnt - b.cnt;
                }
                return a.deepth - b.deepth;
            });

            List<Integer> intList = new ArrayList<>();
            for (DataNode dn : list) {
                intList.add(dn.val);
            }
            ansList.add(intList);
        }
        return ansList;
    }

    private void work(TreeNode root, int w, int d) {
        if (root == null) {return;}

        List<DataNode> list = ansMap.get(w);
        if (!ansMap.containsKey(w)) {
            list = new ArrayList<>();
        }

        list.add(new DataNode(root.val, d, ++cnt));
        ansMap.put(w, list);

        work(root.left, w - 1, d + 1);
        work(root.right, w + 1, d + 1);
    }

}
