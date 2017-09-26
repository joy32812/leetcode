package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 26/09/2017.
 */
public class P685_RedundantConnectionII {

    public int[] findRedundantDirectedConnection(int[][] edges) {

        for (int i = edges.length - 1; i >= 0; i--) {
            if (okay(edges, i)) {
                System.out.println(edges[i][0] + "   " + edges[i][1]);
                return edges[i];
            }
        }

        return edges[0];

    }

    private boolean okay(int[][] edges, int x) {

        int n = edges.length;
        int[] father = new int[n + 1];
        for (int i = 1; i <= n; i++) father[i] = i;

        for (int i = 0; i < n; i++) {
            if (i == x) continue;

            int u = edges[i][0];
            int v = edges[i][1];

            int fu = getFather(father, u);
            int fv = getFather(father, v);

            if (fv != v) return false;

            father[fv] = fu;
        }

        int root = getFather(father, 1);
        for (int i = 1; i <= n; i++) {
            if (getFather(father, i) != root) return false;
        }

        return true;
    }

    private int getFather(int[] father, int x) {
        while (father[x] != x) {
            x = father[x];
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(new P685_RedundantConnectionII().findRedundantDirectedConnection(new int[][]{
                {5, 2},
                {5, 1},
                {3, 1},
                {3, 4},
                {3, 5}
        }));


        System.out.println(new P685_RedundantConnectionII().findRedundantDirectedConnection(new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 1},
                {1, 5},
        }));
    }

}
