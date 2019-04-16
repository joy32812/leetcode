package com.leetcode;

import java.util.Arrays;
import java.util.Map;

public class P785_IsGraphBipartite {


    /**
     * use dfs to color the nodes
     *
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] != -1) continue;
            if (!dfs(i, 0, color, graph)) return false;
        }

        return true;
    }

    private boolean dfs(int i, int val, int[] color, int[][] graph) {
        if (color[i] != -1 && color[i] != val) return false;
        if (color[i] != -1) return true;

        color[i] = val;
        for (int j = 0; j < graph[i].length; j++) {
            if (!dfs(graph[i][j], 1 - val, color, graph)) return false;
        }

        return true;
    }



    public static void main(String[] args) {
        System.out.println(new P785_IsGraphBipartite().isBipartite(new int[][]{
                {1,2,3}, {0,2}, {0,1,3}, {0,2}
        }));
    }

}
