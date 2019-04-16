package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P829_ConsecutiveNumbersSum {

    public int consecutiveNumbersSum(int N) {

        int ans = 0;
        for (int m = 1; ;m++) {
            int mx = N - m * (m - 1) / 2;
            if (mx <= 0) break;

            if (mx % m == 0) ans++;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new P829_ConsecutiveNumbersSum().consecutiveNumbersSum(15));
    }

}
