package com.leetcode;

/**
 * Created by xiaoyuan on 18/04/2017.
 */
public class P277_FindtheCelebrity {

    private boolean knows(int a, int b) {
        return true;
    }

    private int[] celebrityStatus;
    // 0 未知
    // 1 不是

    public int findCelebrity(int n) {
        celebrityStatus = new int[n];

        for (int i = 0; i < n; i++) {
            if(check(i, n)) {
                return i;
            }
        }

        return -1;
    }

    private boolean check(int x, int n) {
        if (celebrityStatus[x] == 1) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (i == x) {continue;}

            if (knows(i, x)) {
                celebrityStatus[i] = 1;
            } else {
                celebrityStatus[x] = 1;
                return false;
            }

            if (knows(x, i)) {
                celebrityStatus[x] = 1;
                return false;
            } else {
                celebrityStatus[i] = 1;
            }
        }

        return true;
    }

}
