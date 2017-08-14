package com.leetcode;

/**
 * Created by xiaoyuan on 14/08/2017.
 */
public class P657_JudgeRouteCircle {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    // up down right left
    public boolean judgeCircle(String moves) {

        int x = 0;
        int y = 0;
        for (char ch : moves.toCharArray()) {
            int d = 0;
            if (ch == 'U') {
                d = 0;
            } else if (ch == 'D') {
                d = 1;
            } else if (ch == 'R') {
                d = 2;
            } else {
                d = 3;
            }

            x += dx[d];
            y += dy[d];
        }

        return x == 0 && y == 0;
    }

}
