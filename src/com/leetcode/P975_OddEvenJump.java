package com.leetcode;

import java.util.*;

public class P975_OddEvenJump {


    /**
     * TreeMap should be much easier
     * @param A
     * @return
     */
    public int oddEvenJumps(int[] A) {

        int ans = 0;

        int n = A.length;
        boolean[][] dp = new boolean[n][2];

        dp[n - 1][0] = true;
        dp[n - 1][1] = true;


        TreeSet<int[]> ceilingTreeSet = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        ceilingTreeSet.add(new int[]{A[n - 1], n - 1});


        TreeSet<int[]> floorTreeSet = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                return o2[1] - o1[1];
            }
        });
        floorTreeSet.add(new int[]{A[n - 1], n - 1});

        for (int i = n - 2; i >= 0; i--) {

            int[] ceiling = ceilingTreeSet.ceiling(new int[]{A[i], 0});

            if (ceiling == null) dp[i][0] = false;
            else {
                dp[i][0] = dp[ceiling[1]][1];
            }


            int[] floor = floorTreeSet.floor(new int[]{A[i], 0});
            if (floor == null) dp[i][1] = false;
            else {
                dp[i][1] = dp[floor[1]][0];
            }



            floorTreeSet.add(new int[]{A[i], i});
            ceilingTreeSet.add(new int[]{A[i], i});
        }

        for (int i = 0; i < n; i++) {
            if (dp[i][0]) ans++;
        }

        return ans;
    }



    public static void main(String[] args) {

//        System.out.println(new BB04().oddEvenJumps(new int[]{5,1,3,4,2}));
        System.out.println(new P975_OddEvenJump().oddEvenJumps(new int[]{1,2,3,2,1,4,4,5}));
//        System.out.println(new BB04().oddEvenJumps(new int[]{10,13,12,14,15}));
    }

}
