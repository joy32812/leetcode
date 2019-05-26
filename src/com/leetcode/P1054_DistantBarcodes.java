package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class P1054_DistantBarcodes {


    /**
     * Greedy to pick the key with max number
     * use PriorityQueue
     * @param barcodes
     * @return
     */
    public int[] rearrangeBarcodes(int[] barcodes) {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int d : barcodes) {
            treeMap.put(d, treeMap.getOrDefault(d, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int k : treeMap.keySet()) {
            pq.add(new int[]{k, treeMap.get(k)});
        }


        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (ans.isEmpty() || now[0] != ans.get(ans.size() - 1)){
                ans.add(now[0]);
                if (now[1] > 1) pq.add(new int[]{now[0], now[1] - 1});
            } else {
                int[] next = pq.poll();
                ans.add(next[0]);
                if (next[1] > 1) pq.add(new int[]{next[0], next[1] - 1});

                pq.add(now);
            }
        }


        int[] z = new int[barcodes.length];
        for (int i = 0; i < barcodes.length; i++) z[i] = ans.get(i);

        return z;
    }


    public static void main(String[] args) {
        System.out.println(new P1054_DistantBarcodes().rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3}));
    }

}
