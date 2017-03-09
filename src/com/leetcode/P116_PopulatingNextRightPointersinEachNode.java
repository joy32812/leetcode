package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 09/03/2017.
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
public class P116_PopulatingNextRightPointersinEachNode {

    Map<Integer, List<TreeLinkNode>> map;

    public void connect(TreeLinkNode root) {
        map = new HashMap<Integer, List<TreeLinkNode>>();

        dfs(root, 1);

        for(int level : map.keySet()) {
            List<TreeLinkNode> nodes = map.get(level);

            for (int i = 0; i < nodes.size() - 1; i++) {
                nodes.get(i).next = nodes.get(i + 1);
            }
        }
    }

    private void dfs(TreeLinkNode root, int level) {
        if (root == null) {return;}

        List<TreeLinkNode> list = map.get(level);
        if (list == null) {list = new ArrayList<TreeLinkNode>();}
        list.add(root);
        map.put(level, list);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        TreeLinkNode t4 = new TreeLinkNode(4);
        TreeLinkNode t5 = new TreeLinkNode(5);
        TreeLinkNode t6 = new TreeLinkNode(6);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.right = t6;

        new P116_PopulatingNextRightPointersinEachNode().connect(t1);

        System.out.println();
    }
}
