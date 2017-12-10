package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 10/12/2017.
 */
public class A2 {

    public int networkDelayTime(int[][] times, int N, int K) {


        Map<Integer, Set<Integer>> toMap = new HashMap<>();
        Map<String, Integer> timeMap = new HashMap<>();
        for (int[] w : times) {
            String key = w[0] + "_" + w[1];

            if (timeMap.containsKey(key)) {
                timeMap.put(key, Math.min(w[2], timeMap.get(key)));
            } else {
                timeMap.put(key, w[2]);
            }

            toMap.computeIfAbsent(w[0], k -> new HashSet<Integer>()).add(w[1]);
        }


        int[] result = new int[N + 1];
        Arrays.fill(result, Integer.MAX_VALUE);

        Queue<Integer> Q = new LinkedList<>();
        Set<Integer> inQ = new HashSet<>();

        Q.add(K);
        inQ.add(K);

        result[K] = 0;

        while (!Q.isEmpty()) {
            int tp = Q.poll();
            inQ.remove(tp);

            Set<Integer> toSet = toMap.computeIfAbsent(tp, k -> new HashSet<Integer>());
            for (int i : toSet) {
                if (i == tp) continue;

                String key = tp + "_" + i;
                if (!timeMap.containsKey(key)) continue;
                int dis = timeMap.get(key);
                if (result[i] <= result[tp] + dis) continue;

                result[i] = result[tp] + dis;
                if (!inQ.contains(i)) {
                    Q.add(i);
                    inQ.add(i);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, result[i]);
        }


        return ans == Integer.MAX_VALUE ? -1 : ans;
    }



    public static void main(String[] args) {

        System.out.println(new A2().networkDelayTime(new int[][]{
                {4,2,76},
{1,3,79},
{3,1,81},
{4,3,30},
{2,1,47},
{1,5,61},
{1,4,99},
{3,4,68},
{3,5,46},
{4,1,6},
{5,4,7},
{5,3,44},
{4,5,19},
{2,3,13},
{3,2,18},
{1,2,0},
{5,1,25},
{2,5,58},
{2,4,77},
{5,2,74}
        }, 5, 3));

    }

}
