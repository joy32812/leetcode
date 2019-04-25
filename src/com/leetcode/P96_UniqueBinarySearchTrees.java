package com.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xiaoyuan on 06/03/2017.
 *
 * use mask to indicate numbers we can use
 */
public class P96_UniqueBinarySearchTrees {

    private long[] visit;

    public int numTrees(int n) {
        visit = new long[n + 1];
        visit[0] = 1;
        visit[1] = 1;

        return (int) count(n);
    }

    private long count(int n) {
        if (visit[n] != 0) return visit[n];

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += count(i) * count(n - i - 1);
        }
        return visit[n] = ans;
    }


    public static void main(String[] args) {
        int ans = new P96_UniqueBinarySearchTrees().numTrees(3);
        System.out.println(ans);
    }

}
