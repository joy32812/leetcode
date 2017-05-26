package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 26/05/2017.
 */
public class P397_IntegerReplacement {

    private Map<Long, Integer> ansMap;

    public int integerReplacement(int n) {
        ansMap = new HashMap<>();
        ansMap.put(1L, 0);

        return work(n);
    }

    private int work(long n) {
        if (ansMap.containsKey(n)) {return ansMap.get(n);}

        if (n % 2 == 0) {
            ansMap.put(n, 1 + work(n / 2));
        } else {
            ansMap.put(n, 1 + Math.min(work(n + 1), work(n - 1)));
        }
        return ansMap.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new P397_IntegerReplacement().integerReplacement(Integer.MAX_VALUE));
        System.out.println(new P397_IntegerReplacement().integerReplacement(8));
    }

}
