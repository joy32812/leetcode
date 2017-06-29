package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xiaoyuan on 29/06/2017.
 */
public class P547_FriendCircles {

    public int findCircleNum(int[][] M) {

        if (M == null || M.length == 0 || M[0].length == 0) {return 0;}

        int n = M.length;
        int ans = 0;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] > 0) {continue;}
            color[i] = ++ans;

            Queue<Integer> Q = new LinkedList<>();
            Q.add(i);

            while (!Q.isEmpty()) {
                int x = Q.poll();

                for (int j = 0; j < n; j++) {
                    if (M[x][j] == 0 || color[j] > 0) {continue;}
                    color[j] = ans;
                    Q.add(j);
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] a = {{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},{0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},{1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},{0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},{0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};

        System.out.println(new P547_FriendCircles().findCircleNum(a));
    }

}
