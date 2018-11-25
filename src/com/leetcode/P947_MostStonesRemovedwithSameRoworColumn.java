package com.leetcode;

import java.util.*;

public class P947_MostStonesRemovedwithSameRoworColumn {


    /**
     * use BFS or union-find to count the islands
     * @param stones
     * @return
     */
    public int removeStones(int[][] stones) {

        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {

            for (int j = 0; j < stones.length; j++) {
                if (i == j) continue;

                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    Set<Integer> ps = edgeMap.computeIfAbsent(i, k -> new HashSet<>());
                    ps.add(j);
                }
            }
        }

        int ans = 0;
        while (true) {

            int now = -1;
            int num = Integer.MAX_VALUE;
            for (int i = 0; i < stones.length; i++) {
                Set<Integer> ps = edgeMap.computeIfAbsent(i, k -> new HashSet<>());
                if (ps.size() == 0) continue;

                if (num > ps.size() || (num == ps.size() && stones[i][0] * stones[i][0] + stones[i][1] * stones[i][1] < stones[now][0] * stones[now][0] + stones[now][1] * stones[now][1])) {
                    now = i;
                    num = ps.size();
                }
            }

            if (now == -1) break;
            ans++;
            edgeMap.put(now, new HashSet<>());

            for (int i = 0; i < stones.length; i++) {
                if (i == now) continue;
                if (stones[i][0] == stones[now][0] || stones[i][1] == stones[now][1]) {
                    Set<Integer> ps = edgeMap.computeIfAbsent(i, k -> new HashSet<>());
                    ps.remove(now);
                }
            }
        }

        return ans;
    }



    public static void main(String[] args) {
        int[][] A = new int[][] {
                {5,9},{9,0},{0,0},{7,0},{4,3},{8,5},{5,8},{1,1},{0,6},{7,5},{1,6},{1,9},{9,4},{2,8},{1,3},{4,2},{2,5},{4,1},{0,2},{6,5}
        };

        System.out.println(A.length);

        System.out.println(new P947_MostStonesRemovedwithSameRoworColumn().removeStones(new int[][]{
                {5,9},{9,0},{0,0},{7,0},{4,3},{8,5},{5,8},{1,1},{0,6},{7,5},{1,6},{1,9},{9,4},{2,8},{1,3},{4,2},{2,5},{4,1},{0,2},{6,5}
        }));
    }

}
