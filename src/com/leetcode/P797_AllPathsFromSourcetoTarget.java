package com.leetcode;

import java.util.*;

public class P797_AllPathsFromSourcetoTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();

        Set<Integer> inStack = new HashSet<>();

        stack.add(0);
        inStack.add(0);

        dfs (0, graph, stack, inStack, ans);

        return ans;
    }

    private void dfs(int s, int[][] graph, LinkedList<Integer>  stack, Set<Integer> inStack, List<List<Integer>> ans) {
        if (s == graph.length - 1) {
            List<Integer> nowList = new ArrayList<>(stack);
            ans.add(nowList);
            return;
        }

        for (int i = 0; i < graph[s].length; i++) {
            int t = graph[s][i];
            if (inStack.contains(t)) continue;

            stack.add(t);
            inStack.add(t);

            dfs(t, graph, stack, inStack, ans);

            stack.removeLast();
            inStack.remove(t);
        }

    }

    public static void main(String[] args) {
        System.out.println(new P797_AllPathsFromSourcetoTarget().allPathsSourceTarget(new int[][]{
                {1, 2},
                {3},
                {3},
                {}
        }));
    }


}
