package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 01/05/2017.
 */
public class P323_NumberofConnectedComponentsinanUndirectedGraph {

    private Map<Integer, List<Integer>> adjMap;
    private int[] color;
    private int ans;
    public int countComponents(int n, int[][] edges) {

        // init adjMap
        adjMap = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            List<Integer> adjA = adjMap.get(a);
            if (adjA == null) {adjA = new ArrayList<>();}
            adjA.add(b);
            adjMap.put(a, adjA);

            List<Integer> adjB = adjMap.get(b);
            if (adjB == null) {adjB = new ArrayList<>();}
            adjB.add(a);
            adjMap.put(b, adjB);
        }


        // color
        color = new int[n];

        ans = 0;
        for (int i = 0;i < n; i++) {
            if (color[i] > 0) {continue;}
            ans++;
            dfs(i);
        }

        return ans;
    }

    private void dfs(int x) {
        if (color[x] > 0) {return;}

        color[x] = ans;
        List<Integer> adj = adjMap.get(x);
        if (adj == null || adj.size() == 0) {return;}

        for (int y : adj) {
            dfs(y);
        }
    }

    public static void main(String[] args) {
        System.out.println(new P323_NumberofConnectedComponentsinanUndirectedGraph().countComponents(5, new int[][]{
                {0, 1},
                {1, 2},
                {3, 4}
        }));
    }

}
