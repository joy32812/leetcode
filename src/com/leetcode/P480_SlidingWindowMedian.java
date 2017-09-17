package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xiaoyuan on 16/09/2017.
 */
public class P480_SlidingWindowMedian {

    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;
    public double[] medianSlidingWindow(int[] nums, int k) {

        low = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        high = new PriorityQueue<>();

        int n = nums.length;
        double[] ans = new double[n - k + 1];
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] <= getMedian()) {
                low.add(nums[i]);
            } else {
                high.add(nums[i]);
            }
            balance();

            if (i - k >= 0) {
                if (nums[i - k] <= getMedian()) {
                    low.remove(nums[i - k]);
                } else {
                    high.remove(nums[i - k]);
                }
                balance();
            }

            if (i - k + 1 >= 0) {
                ans[i - k + 1] = getMedian();
            }
        }

        return ans;
    }

    private void balance() {
        if (high.size() > low.size()) {
            low.add(high.poll());
        }

        if (low.size() > high.size() + 1) {
            high.add(low.poll());
        }
    }

    private double getMedian() {
        if (low.size() == 0) return 0;

        if (low.size() == high.size()) {
            return (0.0 + low.peek() + high.peek()) / 2.0;
        }

        return 0.0 + low.peek();
    }


    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.add(2147483647);
        pq.add(2147483647);
        pq.add(-2147483648);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        System.out.println(new P480_SlidingWindowMedian().medianSlidingWindow(new int[]{
                -2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648
        }, 3));
//        System.out.println(new P480_SlidingWindowMedian().medianSlidingWindow(new int[]{
//                1, 3, -1, -3, 5, 3, 6, 7
//        }, 3));
    }

}
