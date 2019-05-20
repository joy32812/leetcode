package com.leetcode;

import java.util.*;

public class P1049_LastStoneWeightII {


    public int lastStoneWeightII(int[] stones) {

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 10000; i++) {
            ans = Math.min(ans, getAns(stones));
            if (ans == 0) return 0;
        }

        return ans;
    }

    private int getAns(int[] stones) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int d : stones) list.add(d);

        while (list.size() >= 2) {
            Collections.shuffle(list);

            int first = list.removeLast();
            int last = list.removeLast();

            if (first != last) {
                list.add(Math.abs(first - last));
            }
        }

        if (list.size() == 1) return list.getFirst();
        return 0;

    }


    public static void main(String[] args) {

        System.out.println(new P1049_LastStoneWeightII().lastStoneWeightII(new int[]{2,7,4,1,8,1}));
        System.out.println(new P1049_LastStoneWeightII().lastStoneWeightII(new int[]{31,26,33,21,40}));
    }

}
