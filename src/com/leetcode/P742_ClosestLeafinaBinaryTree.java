package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 10/12/2017.
 */
public class P742_ClosestLeafinaBinaryTree {


    Map<Integer, Set<Integer>> toMap;
    Queue<Integer> Q;
    Set<Integer> inQ;

    Map<Integer, Integer> ansMap;
    Map<Integer, Integer> fromMap;
    public int findClosestLeaf(TreeNode root, int z) {

        toMap = new HashMap<>();
        ansMap = new HashMap<>();
        fromMap = new HashMap<>();

        Q = new LinkedList<>();
        inQ = new HashSet<>();

        work(root, -1);


        while (!Q.isEmpty()) {

            int tp = Q.poll();
            Q.remove(tp);

            Set<Integer> toSet = toMap.computeIfAbsent(tp, k -> new HashSet<Integer>());
            for (int to : toSet) {

                int dis = 1;
                if (ansMap.containsKey(to) && ansMap.get(to) <= ansMap.get(tp) + 1) continue;

                ansMap.put(to, ansMap.get(tp) + 1);
                fromMap.put(to, tp);
                if (!inQ.contains(to)) {
                    Q.add(to);
                    inQ.add(to);
                }

            }

        }

        return getFrom(z);
    }

    private int getFrom(int k) {
        while (!(fromMap.get(k) == k)) {
            k = fromMap.get(k);
        }
        return k;
    }

    private void work(TreeNode root, int father) {

        if (father != -1) {
            toMap.computeIfAbsent(root.val, k -> new HashSet<Integer>()).add(father);
            toMap.computeIfAbsent(father, k -> new HashSet<Integer>()).add(root.val);
        }

        if (root.left == null && root.right == null) {
            Q.add(root.val);
            ansMap.put(root.val, 0);
            fromMap.put(root.val, root.val);
            inQ.add(root.val);
        }

        if (root.left != null) {
            toMap.computeIfAbsent(root.val, k -> new HashSet<Integer>()).add(root.left.val);
            toMap.computeIfAbsent(root.left.val, k -> new HashSet<Integer>()).add(root.val);

            work(root.left, root.val);
        }

        if (root.right != null) {
            toMap.computeIfAbsent(root.val, k -> new HashSet<Integer>()).add(root.right.val);
            toMap.computeIfAbsent(root.right.val, k -> new HashSet<Integer>()).add(root.val);

            work(root.right, root.val);
        }

    }


    public static void main(String[] args) {

    }

}
