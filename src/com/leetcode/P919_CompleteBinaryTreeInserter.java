package com.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CBTInserter {

    List<TreeNode> nodeList;
    public CBTInserter(TreeNode root) {
        nodeList = new ArrayList<>();

        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            TreeNode now = Q.poll();
            nodeList.add(now);
            if (now.left != null) Q.add(now.left);
            if (now.right != null) Q.add(now.right);
        }
    }

    public int insert(int v) {
        TreeNode now = new TreeNode(v);
        nodeList.add(now);

        int pos = nodeList.size() - 1;

        int fatherPos = (pos - 1) / 2;
        TreeNode father = nodeList.get(fatherPos);

        if (fatherPos * 2 + 1 == pos) father.left = now;
        else father.right = now;

        return father.val;
    }

    public TreeNode get_root() {
        return nodeList.get(0);
    }
}

public class P919_CompleteBinaryTreeInserter {

}
