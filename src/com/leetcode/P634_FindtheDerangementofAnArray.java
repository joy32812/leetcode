package com.leetcode;

/**
 * Created by xiaoyuan on 03/07/2017.
 */
public class P634_FindtheDerangementofAnArray {

    private static final int MOD = 1000000000 + 7;
    public int findDerangement(int n) {
        if (n == 1) {return 0;}
        if (n == 2) {return 1;}

        long N_1 = 1;
        long N_2 = 0;
        for (int i = 3; i <= n; i++) {
            long now = ((N_1 + N_2 + MOD)% MOD) * (i - 1) % MOD;

            N_2 = N_1;
            N_1 = now;
        }

        return (int)((N_1 + MOD) % MOD);
    }

}
