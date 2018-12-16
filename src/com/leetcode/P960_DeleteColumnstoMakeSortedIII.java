package com.leetcode;

import java.util.Arrays;

public class P960_DeleteColumnstoMakeSortedIII {

    public int minDeletionSize(String[] A) {

        int m = A.length;
        int n = A[0].length();

        int ans = 0;


        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int j = 1; j < n; j++) {

            for (int k = 0; k < j; k++) {

                boolean okay = true;
                for (int i = 0; i < m; i++) {
                    if (A[i].charAt(j) < A[i].charAt(k)) {
                        okay = false;
                    }
                }

                if (!okay) continue;

                dp[j] = Math.max(dp[j], dp[k] + 1);
            }
        }

        return n - Arrays.stream(dp).max().getAsInt();
    }



    public static void main(String[] args) {

//        System.out.println(new P960_DeleteColumnstoMakeSortedIII().minDeletionSize(new String[]{
//                "babca","bbazb"
//        }));

        System.out.println(new P960_DeleteColumnstoMakeSortedIII().minDeletionSize(new String[]{
                "aaababa","ababbaa"
        }));

    }
}
