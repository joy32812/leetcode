package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 02/05/2017.
 */
public class P310_MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {return Collections.singletonList(0);}

        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {adj.add(new HashSet<>());}

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {ans.add(i);}
        }

        while (n > 2) {
            n -= ans.size();

            List<Integer> tmpAns = new ArrayList<>();
            for (int x : ans) {
                for (int y : adj.get(x)) {
                    adj.get(y).remove(x);
                    if (adj.get(y).size() == 1) {
                        tmpAns.add(y);
                    }
                }
            }

            ans = tmpAns;
        }


        return ans;
    }

}
