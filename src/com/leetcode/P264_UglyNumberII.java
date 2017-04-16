package com.leetcode;

import java.util.PriorityQueue;

/**
 * Created by xiaoyuan on 16/04/2017.
 */
public class P264_UglyNumberII {

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> (a.intValue() - b.intValue()));
        pq.add(1L);

        Long ans = 0L;
        for (int i = 1; i <= n; i++) {
            ans = pq.poll();

            Long now = ans * 2;
            if(now <= Integer.MAX_VALUE && !pq.contains(now)) {
                pq.add(now);
            }
            now = ans * 3;
            if(now <= Integer.MAX_VALUE && !pq.contains(now)) {
                pq.add(now);
            }
            now = ans * 5;
            if(now <= Integer.MAX_VALUE && !pq.contains(now)) {
                pq.add(now);
            }
        }

        return ans.intValue();
    }


    public static void main(String[] args) {
        System.out.println(new P264_UglyNumberII().nthUglyNumber(1000));
        System.out.println(new P264_UglyNumberII().nthUglyNumber(1432));
    }
}
