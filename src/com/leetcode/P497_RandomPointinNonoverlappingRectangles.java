package com.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class P497_RandomPointinNonoverlappingRectangles {

    class Solution {

        TreeMap<Integer, Integer> treeMap;
        int[][] rs;
        int area = 0;
        public Solution(int[][] rects) {
            rs = rects;
            treeMap = new TreeMap<>();

//            Arrays.sort(rs, (a, b) -> {
//                if (a[0] == b[0]) return a[1] - b[1];
//                return a[0] - b[0];
//            });

            area = 0;
            for (int i = 0; i < rs.length; i++) {
                int[] r = rs[i];
                area += (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
                treeMap.put(area, i);
            }
        }

        public int[] pick() {
            int rand = new Random().nextInt(area) + 1;
            Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(rand);
            int ind = entry.getValue();

            int[] r = rs[ind];
            int edge = r[2] - r[0] + 1;
            int nowArea = (r[2] - r[0] + 1) * (r[3] - r[1] + 1);

            int remain = rand - (entry.getKey() - nowArea) - 1;

            int row = remain / edge;
            int col = remain % edge;

            return new int[]{r[0] + col, r[1] + row};
        }
    }


    public static void main(String[] args) {

    }

}
