package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 06/09/2017.
 */
public class P465_OptimalAccountBalancing {

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> balanceMap = new HashMap<>();

        for (int[] tran : transactions) {
            int x = tran[0];
            int y = tran[1];
            int z = tran[2];
            balanceMap.put(x, balanceMap.getOrDefault(x, 0) - z);
            balanceMap.put(y, balanceMap.getOrDefault(y, 0) + z);
        }

        List<Integer> poss = new ArrayList<>();
        List<Integer> negs = new ArrayList<>();

        for (int key : balanceMap.keySet()) {
            int m = balanceMap.get(key);
            if (m > 0) {
                poss.add(m);
            } else if (m < 0) {
                negs.add(-m);
            }
        }

        int ans = Integer.MAX_VALUE;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        for (int i = 1; i <= 1000; i++) {
            for (int v : poss) s1.push(v);
            for (int v : negs) s2.push(v);

            int cnt = 0;
            while (!s1.isEmpty()) {
                int a = s1.pop();
                int b = s2.pop();

                cnt++;
                if (a == b) continue;
                if (a > b) {
                    s1.add(a - b);
                } else {
                    s2.add(b - a);
                }
            }

            ans = Math.min(ans, cnt);

            Collections.shuffle(poss);
            Collections.shuffle(negs);
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new P465_OptimalAccountBalancing().minTransfers(new int[][]{
                {1,8,1},{1,13,21},{2,8,10},{3,9,20},{4,10,61},{5,11,61},{6,12,59},{7,13,60}
        }));
    }

}
