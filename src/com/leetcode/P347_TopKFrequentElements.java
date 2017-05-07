package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 07/05/2017.
 */
public class P347_TopKFrequentElements {

    private class DataNode {
        int frq;
        int val;

        public DataNode(int frq, int val) {
            this.frq = frq;
            this.val = val;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        // get frq
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int d : nums) {
            if (!countMap.containsKey(d)) {
                countMap.put(d, 1);
            } else {
                countMap.put(d, countMap.get(d) + 1);
            }
        }

        // use priority queue
        PriorityQueue<DataNode> pq = new PriorityQueue<>((a, b) -> (a.frq - b.frq));
        for (int d : countMap.keySet()) {
            int f = countMap.get(d);

            pq.add(new DataNode(f, d));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll().val);
        }

        return ans;
    }

}
