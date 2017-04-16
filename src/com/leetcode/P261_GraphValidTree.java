package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 16/04/2017.
 */
public class P261_GraphValidTree {

    private int[] father;

    public boolean validTree(int n, int[][] edges) {
        if (n == 0) {return true;}
        if (edges.length != n - 1) {return false;}

        father = new int[n];
        Arrays.fill(father, -1);

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            int fa = findFather(a);
            int fb = findFather(b);
            if (fa == fb) {return false;}
            father[fb] = fa;
        }

        return true;

    }

    private int findFather(int n) {
        while (father[n] != -1) {
            n = father[n];
        }
        return n;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] es = new int[][] {
                {0, 1},
                {2, 1},
                {2, 0},
                {2, 4}
        };

        System.out.println(new P261_GraphValidTree().validTree(n, es));
    }

}
