package com.leetcode;


import java.util.HashSet;
import java.util.Set;

public class P874_WalkingRobotSimulation {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1,0, -1, 0};
    public int robotSim(int[] commands, int[][] obstacles) {

        Set<String> stones = new HashSet<>();
        for (int[] ob : obstacles) stones.add(ob[0] + "_" + ob[1]);


        int x = 0;
        int y = 0;
        int k = 0;

        int ans = 0;
        for (int d : commands) {
            if (d == -2) k = (k + 4 - 1) % 4;
            else if (d == -1) k = (k + 4 + 1) % 4;
            else {
                for (int i = 0; i < d; i++) {
                    int tx = x + dx[k];
                    int ty = y + dy[k];

                    if (stones.contains(tx + "_" + ty)) break;
                    x = tx;
                    y = ty;

                    ans = Math.max(ans, x * x + y * y);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P874_WalkingRobotSimulation().robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));
    }


}
