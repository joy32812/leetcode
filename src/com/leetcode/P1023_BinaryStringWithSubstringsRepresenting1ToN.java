package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P1023_BinaryStringWithSubstringsRepresenting1ToN {


    /**
     * O(S^2)
     * find the possible integer
     *
     * @param S
     * @param N
     * @return
     */
    public boolean queryString(String S, int N) {

        int len = S.length();
        Set<Integer> numSet = new HashSet<>();

        for (int z = 1; z <= len; z++) {

            int now = 0;
            for (int i = 0; i < z; i++) now = now * 2 + (S.charAt(i) - '0');
            numSet.add(now);

            for (int i = z; i < len; i++) {
                if (S.charAt(i - z) == '1') now -= (1 << (z - 1));
                now = now * 2 + (S.charAt(i) - '0');
                numSet.add(now);
            }
        }

        if (numSet.size() < N) return false;
        for (int i = 1; i <= N; i++) {
            if (!numSet.contains(i)) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(new P1023_BinaryStringWithSubstringsRepresenting1ToN().queryString("0110", 3));
        System.out.println(new P1023_BinaryStringWithSubstringsRepresenting1ToN().queryString("0110", 4));
    }

}
