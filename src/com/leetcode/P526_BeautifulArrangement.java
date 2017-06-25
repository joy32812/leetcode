package com.leetcode;

/**
 * Created by xiaoyuan on 25/06/2017.
 */
public class P526_BeautifulArrangement {

    private boolean[] used;
    private int ans;
    public int countArrangement(int N) {
        ans = 0;
        used = new boolean[N + 1];

        work(1, N);

        return ans;
    }

    private void work(int p, int n) {
        if (p == n + 1) {
            ans++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i]) {continue;}
            if (i % p != 0 && p % i != 0) {continue;}
            used[i] = true;
            work(p + 1, n);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P526_BeautifulArrangement().countArrangement(15));
    }

}
