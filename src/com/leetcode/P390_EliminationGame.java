package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 24/05/2017.
 */
public class P390_EliminationGame {

    private int N;

    public int lastRemaining(int n) {

        N = n;

        return work(1, 1, 0);
    }

    private int work(int begin, int step, int direction) {

        String key = begin + "_" + step + "_" + direction;

        int res = 0;
        if (begin + step > N) {
            res = begin;
        } else {
            if (direction == 0) {
                res = work(begin + step, step * 2, 1);
            } else {
                int num = 1 + (N - begin) / step;

                if (num % 2 == 0) {
                    res = work(begin, step * 2, 1 - direction);
                } else {
                    res = work(begin + step, step * 2, 1 - direction);
                }

            }

        }

        return res;
    }

    public int lastRemaining2(int n) {
        return ((Integer.highestOneBit(n) - 1) & (n | 0x55555555)) + 1;
    }


    public static void main(String[] args) {
        System.out.println(new P390_EliminationGame().lastRemaining(23824234));
        System.out.println(new P390_EliminationGame().lastRemaining2(23824234));
    }

}
