package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P923_3SumWithMultiplicity {

    long MOD = 1000000000 + 7;
    public int threeSumMulti(int[] A, int target) {

        Map<Integer, Long> cntMap = new HashMap<>();
        for (int d : A) cntMap.put(d, cntMap.getOrDefault(d, 0l) + 1);

        long ans = 0;

        // three same
        for (int d : cntMap.keySet()) {
            long num = cntMap.get(d);
            if (d * 3 == target) {
                long now = (num * (num - 1) * (num - 2) / 6) % MOD;
                ans += now;
            }
        }

        // two same
        for (int d: cntMap.keySet()) {
            long num = cntMap.get(d);
            if (2 * d <= target && target - 2 * d != d) {
                int t = target - 2 * d;
                long now = (num * (num - 1) / 2) * cntMap.getOrDefault(t, 0l) % MOD;
                ans = (ans + now) % MOD;
            }
        }

        // other
        for (int x : cntMap.keySet()) {
            for (int y : cntMap.keySet()) {
                if (x >= y) continue;
                int z = target - x - y;
                if (z <= x || z <= y) continue;

                long nx = cntMap.get(x);
                long ny = cntMap.get(y);
                long nz = cntMap.getOrDefault(z, 0l);
                ans = (ans + nx * ny * nz) % MOD;
            }
        }


        return (int) ans;
    }


    public static void main(String[] args) {
        System.out.println(new P923_3SumWithMultiplicity().threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
        System.out.println(new P923_3SumWithMultiplicity().threeSumMulti(new int[]{1, 1, 2, 2, 2, 2}, 5));
    }

}
