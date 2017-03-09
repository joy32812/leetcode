package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P117_PopulatingNextRightPointersinEachNodeII {

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
    }
}
