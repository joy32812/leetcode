package com.leetcode;

import java.util.*;

public class P1048_LongestStringChain {


    /**
     * topological sort
     * @param words
     * @return
     */
    public int longestStrChain(String[] words) {

        int n = words.length;

        Map<Integer, Set<Integer>> adjMap = new HashMap<>();
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (predecessor(words[i], words[j])) {
                    adjMap.computeIfAbsent(i, k -> new HashSet<>()).add(j);
                    in[j] ++;
                }
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        int[] dis = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                dis[i] = 1;
                Q.add(i);
            }
        }

        while (!Q.isEmpty()) {
            int x = Q.poll();
            ans = Math.max(ans, dis[x]);

            Set<Integer> adjSet = adjMap.computeIfAbsent(x, k -> new HashSet<>());
            for (int y : adjSet) {
                if (dis[y] < dis[x] + 1) {
                    dis[y] = dis[x] + 1;
                }
                in[y] --;
                if (in[y] == 0) {
                    Q.add(y);
                }
            }
        }


        return ans;
    }

    private boolean predecessor(String s, String t) {
        if (s.length() + 1 != t.length()) return false;

        for (int i = 0; i < t.length(); i++) {
            String now = t.substring(0, i) + t.substring(i + 1);
            if (now.equals(s)) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new P1048_LongestStringChain().longestStrChain(new String[]{
                "ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"
        }));

        System.out.println(new P1048_LongestStringChain().predecessor("ksqsq", "ksqvsq"));

    }

}
