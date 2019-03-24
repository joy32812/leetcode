package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P1022_SmallestIntegerDivisiblebyK {


    /**
     * brute force to find min ans
     * keep mod every time
     * @param K
     * @return
     */
    public int smallestRepunitDivByK(int K) {
        if (K == 1) return 1;

        int now = 1;
        Set<Integer> modSet = new HashSet<>();
        modSet.add(now);

        int ans = 1;
        while (true) {
            ans++;
            now = now * 10 + 1;

            if (now % K == 0) return ans;

            now %= K;
            if (modSet.contains(now)) break;
            modSet.add(now);
        }

        return -1;
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 20; i++) {
            System.out.println(new P1022_SmallestIntegerDivisiblebyK().smallestRepunitDivByK(i));
        }

    }

}
