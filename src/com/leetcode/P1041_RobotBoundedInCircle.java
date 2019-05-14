package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P1041_RobotBoundedInCircle {


    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public boolean isRobotBounded(String instructions) {

        int k = 0;
        int x = 0;
        int y = 0;

        Set<String> pointSet = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            for (char ch : instructions.toCharArray()) {
                if (ch == 'G') {
                    x += dx[k];
                    y += dy[k];
                } else if (ch == 'L') {
                    k = (k + 4 - 1) % 4;
                } else {
                    k = (k + 4 + 1) % 4;
                }
                pointSet.add(x + "_" + y);
            }
        }

        for (int i = 0; i < 100; i++) {
            for (char ch : instructions.toCharArray()) {
                if (ch == 'G') {
                    x += dx[k];
                    y += dy[k];
                } else if (ch == 'L') {
                    k = (k + 4 - 1) % 4;
                } else {
                    k = (k + 4 + 1) % 4;
                }
                if (!pointSet.contains(x + "_" + y)) return false;
            }
        }

        return true;

    }



    public static void main(String[] args) {

    }

}
