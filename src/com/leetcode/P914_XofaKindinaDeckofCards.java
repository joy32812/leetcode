package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P914_XofaKindinaDeckofCards {

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int d : deck) cntMap.put(d, cntMap.getOrDefault(d, 0) + 1);

        int gcd = -1;
        for (int num : cntMap.values()) {

            if (gcd == -1) gcd = num;
            else {
                gcd = gcd(gcd, num);
            }

            if (gcd == 1) return false;
        }

        return true;
    }

    private int gcd(int x, int y) {
        if (x < y) return gcd(y, x);

        if (x % y == 0) return y;

        return gcd(x % y, y);
    }

    public static void main(String[] args) {
        System.out.println(new P914_XofaKindinaDeckofCards().gcd(4, 6));
    }

}
