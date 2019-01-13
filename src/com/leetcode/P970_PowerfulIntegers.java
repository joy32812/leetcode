package com.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P970_PowerfulIntegers {



    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        Set<Long> xSet = getSet(x, bound);
        Set<Long> ySet = getSet(y, bound);

        Set<Integer> ansSet = new HashSet<>();
        for (long a : xSet) {
            for (long b : ySet) {
                if (a + b <= bound) ansSet.add((int)(a + b));
            }
        }

        return ansSet.stream().collect(Collectors.toList());

    }

    private Set<Long> getSet(int n, int bound) {
        Set<Long> nowSet = new HashSet<>();
        nowSet.add(1l);
        if (n == 1) return nowSet;

        long x = 1;
        for (int i = 1; ; i++) {
            x = x * n;
            if (x > bound) break;
            nowSet.add(x);
        }

        return nowSet;
    }


    public static void main(String[] args) {

        System.out.println(new P970_PowerfulIntegers().powerfulIntegers(2, 3, 10));
        System.out.println(new P970_PowerfulIntegers().powerfulIntegers(3, 5, 15));

    }

}
