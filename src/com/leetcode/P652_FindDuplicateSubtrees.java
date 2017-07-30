package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 30/07/2017.
 */
public class P652_FindDuplicateSubtrees {

    List<TreeNode> ans;
    Map<String, TreeNode> nodeMap;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ans = new ArrayList<>();
        nodeMap = new HashMap<>();

        dfs(root);

        return ans;
    }

    private String dfs(TreeNode root) {
        if (root == null) {return "()";}

        String left = dfs(root.left);
        String right = dfs(root.right);

        String total = "(" + root.val + left + right + ")";

        if (nodeMap.containsKey(total)) {
            if (nodeMap.get(total).val != Integer.MAX_VALUE) {
                ans.add(nodeMap.get(total));
                nodeMap.put(total, new TreeNode(Integer.MAX_VALUE));
            }
        } else {
            nodeMap.put(total, root);
        }
        return total;
    }

}
