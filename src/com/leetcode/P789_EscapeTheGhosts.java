package com.leetcode;

public class P789_EscapeTheGhosts {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {

        int ans = Integer.MAX_VALUE;
        for (int[] ghost : ghosts) {
            ans = Math.min(ans, Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1]));
        }

        return ans > Math.abs(target[0]) + Math.abs(target[1]);
    }

    public static void main(String[] args) {
        System.out.println(new P789_EscapeTheGhosts().escapeGhosts(new int[][]{
                {1, 0}
        }, new int[]{2, 0}));
    }

}
