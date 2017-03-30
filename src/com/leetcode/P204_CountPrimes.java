package com.leetcode;

/**
 * Created by xiaoyuan on 30/03/2017.
 */
public class P204_CountPrimes {

    public int countPrimes(int n) {
        boolean[] noPrime = new boolean[n];
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (noPrime[i] == false) {
                ans ++;

                for (int j = 2; i * j < n; j++) {
                    noPrime[i * j] = true;
                }
            }
        }

        return ans;
    }

}
