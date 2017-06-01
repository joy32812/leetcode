package com.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by xiaoyuan on 01/06/2017.
 */
public class P414_ThirdMaximumNumber {

    public int thirdMax(int[] nums) {

        Set<Integer> numSet = new HashSet<>();
        for (int d : nums) {numSet.add(d);}
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (a > b) {return 1;}
            if (a == b) {return 0;}
            return -1;
        });
        for (int d : numSet) {
            pq.add(d);

            if (pq.size() >= 4) {
                pq.poll();
            }
        }

        if (pq.size() >= 3) {return pq.poll();}

        int ans = pq.poll();
        while (!pq.isEmpty()) {ans = pq.poll();}
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P414_ThirdMaximumNumber().thirdMax(new int[]{1, 2, 2}));
        System.out.println(new P414_ThirdMaximumNumber().thirdMax(new int[]{1, 2, 2, 5, 3, 5}));
    }

}
