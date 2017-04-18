package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 18/04/2017.
 */
public class P279_PerfectSquares {

    private Map<Integer, Integer> ansMap;

    public int numSquares(int n) {
        ansMap = new HashMap<>();
        return work(n);
    }

    private int work(int x) {
        if (ansMap.containsKey(x)) {return ansMap.get(x);}

        int sq = (int)Math.sqrt(x + 0.2);
        if (sq * sq == x) {
            ansMap.put(x, 1);
            return 1;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = sq; i >= 1; i--) {
            int left = work(x - i * i);
            if (left == 1) {
                ansMap.put(x, 2);
                return 2;
            }

            ans = Math.min(ans, left + 1);
        }

        ansMap.put(x, ans);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P279_PerfectSquares().numSquares(41));
        System.out.println(new P279_PerfectSquares().numSquares(12));
        System.out.println(new P279_PerfectSquares().numSquares(13));
        System.out.println(new P279_PerfectSquares().numSquares(100003));
//        System.out.println(Math.sqrt(0.1 + Integer.MAX_VALUE));
//        System.out.println(new P279_PerfectSquares().numSquares(Integer.MAX_VALUE));
    }

}
