package com.leetcode;

import java.util.Arrays;

public class P983_MinimumCostForTickets {

    /**
     * dp
     * dp[i]: the min cost for all the days less than day[i]
     * use dp[i] to update all the days it can get
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {

        int[] dp = new int[400];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < days.length; i++) {

            int last = 0;
            if (i > 0) last = dp[i - 1];

            dp[i] = Math.min(dp[i], costs[0] + last);

            for (int j = i + 1; j < days.length; j++) {
                if (days[i] + 7 > days[j]) {
                    dp[j] = Math.min(dp[j], costs[1] + last);
                }
                if (days[i] + 30 > days[j]) {
                    dp[j] = Math.min(dp[j], costs[2] + last);
                }
            }
        }

        return dp[days.length - 1];

//        Set<Integer> set = new HashSet<>();
//        for (int d : days) set.add(d);
//
//
//
//
//        int[] dp = new int[400];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//
//        for (int i = 0; i < 366; i++) {
//
//            int now = i + 1;
//            for (int j = i + 1; j <= now; j++) {
//                dp[j] = Math.min(dp[j], dp[i] + costs[0]);
//            }
//
//
//            now = i + 7;
//            for (int j = i + 1; j <= now; j++) {
//                dp[j] = Math.min(dp[j], dp[i] + costs[1]);
//            }
//
//
//            now = i + 30;
//            for (int j = i + 1; j <= now; j++) {
//                dp[j] = Math.min(dp[j], dp[i] + costs[2]);
//            }
//        }

//        return 0;
    }



    public static void main(String[] args) {

        System.out.println(new P983_MinimumCostForTickets().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));

    }

}
