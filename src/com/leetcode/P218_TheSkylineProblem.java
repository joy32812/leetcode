package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 06/04/2017.
 */
public class P218_TheSkylineProblem {

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            heights.add(new int[]{buildings[i][0], -buildings[i][2]});
            heights.add(new int[]{buildings[i][1], buildings[i][2]});
        }

        Collections.sort(heights, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        List<int[]> ans = new ArrayList<>();

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int pre = 0;
        for (int[] height : heights) {
            if (height[1] < 0) {
                pq.offer(-height[1]);
            } else {
                pq.remove(height[1]);
            }

            int cur = pq.peek();
            if (pre != cur) {
                ans.add(new int[]{height[0], cur});
                pre = cur;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(new P218_TheSkylineProblem().getSkyline(new int[][]{
                {1, 10, 10},
                {2, 10, 9},
                {3, 10, 8},
                {4, 10, 15},
                {5, 10, 6},
                {6, 10, 5},
                {7, 10, 18},
                {8, 10, 3},
                {9, 10, 2},
        }));

    }

}
