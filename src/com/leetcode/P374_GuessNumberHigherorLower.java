package com.leetcode;

/**
 * Created by xiaoyuan on 18/05/2017.
 */

public class P374_GuessNumberHigherorLower {

    public int guess(int num) {
        return -1;
    }

    public int guessNumber(int n) {
        long l = 1, r = n;
        while (l < r) {
            int m = (int)((l + r) / 2);
            if (guess(m) == 0) {
                return m;
            } else if (guess(m) == -1) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return (int)l;
    }

}
