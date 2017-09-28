package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 28/09/2017.
 */
public class P632_SmallestRange {

    public int[] smallestRange(List<List<Integer>> nums) {

        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;

        PriorityQueue<LinkedList<Integer>> pq = new PriorityQueue<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                LinkedList<Integer> a = (LinkedList<Integer>)o1;
                LinkedList<Integer> b = (LinkedList<Integer>)o2;
                return a.getFirst() - b.getFirst();
            }
        });

        for (List<Integer> list : nums) {
            l = Math.min(l, list.get(0));
            r = Math.max(r, list.get(0));

            LinkedList<Integer> now = new LinkedList<>(list);
            pq.add(now);
        }

        int nowMax = r;
        int[] ans = {l, r};
        while (!pq.isEmpty()) {
            LinkedList<Integer> top = pq.poll();
            top.removeFirst();
            if (top.size() == 0) break;

            nowMax = Math.max(nowMax, top.getFirst());
            int bb = nowMax;
            pq.add(top);
            int aa = pq.peek().getFirst();

            if (bb - aa < ans[1] - ans[0] || (bb - aa == ans[1] - ans[0] && aa < ans[0])) {
                ans = new int[]{aa, bb};
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> a = new ArrayList<>();

        a.add(Arrays.asList(4, 10, 15, 24, 26));
        a.add(Arrays.asList(0, 9, 12, 20));
        a.add(Arrays.asList(5, 18, 22, 30));


        System.out.println(new P632_SmallestRange().smallestRange(a));
    }

}
