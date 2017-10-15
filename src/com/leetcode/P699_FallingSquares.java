package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 15/10/2017.
 */
public class P699_FallingSquares {

    public List<Integer> fallingSquares(int[][] positions) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int[] pos : positions) {
            treeSet.add(pos[0]);
            treeSet.add(pos[0] + pos[1] - 1);
        }

        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : treeSet) {
            map.put(d, ++cnt);
        }

        List<Integer> res = new ArrayList<>();
        int[] floor = new int[cnt + 1];
        int ans = 0;
        for (int[] pos : positions) {
            int left = map.get(pos[0]);
            int right = map.get(pos[0] + pos[1] - 1);

            int max = Integer.MIN_VALUE;
            for (int i = left; i<= right; i++) {
                max = Math.max(max, floor[i]);
            }

            int now = max + pos[1];
            for (int i = left; i <= right; i++) {
                floor[i] = now;
            }

            ans = Math.max(ans, now);
            res.add(ans);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P699_FallingSquares().fallingSquares(new int[][]{
                {1, 2},
                {2, 3},
                {6, 1},
        }));
    }

}
