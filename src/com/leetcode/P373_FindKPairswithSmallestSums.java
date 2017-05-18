package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by xiaoyuan on 18/05/2017.
 */
public class P373_FindKPairswithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length <= 0 || nums2.length <= 0) {return new ArrayList<int[]>();}

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.add(new int[]{nums1[i], nums2[0], 0});
        }

        List<int[]> ans = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            ans.add(new int[]{top[0], top[1]});
            if (top[2] >= nums2.length - 1) {continue;}

            pq.add(new int[]{top[0], nums2[top[2] + 1], top[2] + 1});
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P373_FindKPairswithSmallestSums().kSmallestPairs(new int[]{}, new int[]{}, 3));
    }
}
