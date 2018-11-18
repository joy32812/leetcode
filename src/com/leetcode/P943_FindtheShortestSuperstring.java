package com.leetcode;

import java.util.*;

public class P943_FindtheShortestSuperstring {


    /**
     * DP
     * @param A
     * @return
     */
    public String shortestSuperstring(String[] A) {
        int N = A.length;

        int[][] overlap = new int[N][N];
        int[][] dp = new int[1 << N][N];
        int[][] from = new int[1 << N][N];


        // get overlap
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = Math.min(A[i].length(), A[j].length()); k >= 0; k--) {
                    if (A[i].substring(A[i].length() - k).equals(A[j].substring(0, k))) {
                        overlap[i][j] = k;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < (1 << N); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            Arrays.fill(from[i], -1);
        }

        Queue<int[]> Q = new LinkedList<>();
        Set<String> inQ = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int mask = 1 << i;

            dp[mask][i] = A[i].length();
            Q.add(new int[]{mask, i});
            inQ.add(mask + "_" + i);
        }

        while (!Q.isEmpty()) {
            int[] tp = Q.poll();
            int mask = tp[0];
            int p = tp[1];
            inQ.remove(mask + "_" + p);

            for (int i = 0; i < N; i++) {
                if (p == i) continue;
                if ((mask & (1 << i)) > 0) continue;

                int newMask = mask | (1 << i);
                if (dp[newMask][i] > dp[mask][p] + A[i].length() - overlap[p][i]) {
                    dp[newMask][i] = dp[mask][p] + A[i].length() - overlap[p][i];
                    from[newMask][i] = p;

                    Q.add(new int[]{newMask, i});
                    inQ.add(newMask + "_" + i);
                }
            }
        }

        int p = 0;
        for (int i = 0; i < N; i++) {
            if (dp[(1 << N) - 1][p] > dp[(1 << N) - 1][i]) p = i;
        }

        List<Integer> indexList = new ArrayList<>();
        indexList.add(p);


        int nowMask = (1 << N) - 1;
        while (from[nowMask][p] != -1) {
            int prev = from[nowMask][p];

            indexList.add(prev);
            nowMask = nowMask ^ (1 << p);
            p = prev;
        }

        StringBuilder sb = new StringBuilder(A[indexList.get(N - 1)]);
        for (int i = N - 2; i >= 0; i--) {
            int prev = indexList.get(i + 1);
            int now = indexList.get(i);

            sb.append(A[now].substring(overlap[prev][now]));
        }


        return sb.toString();
    }






    public static void main(String[] args) {

        System.out.println(new P943_FindtheShortestSuperstring().shortestSuperstring(new String[]{"ift","efd","dnete","tef","fdn"}));
//        System.out.println(new AA4().shortestSuperstring(new String[]{"catg","ctaagt","gcta","ttca","atgcatc"}));
    }

}
