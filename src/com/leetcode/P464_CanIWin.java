package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 10/06/2017.
 */
public class P464_CanIWin {

    private Map<Integer, Boolean> ansMap;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        ansMap = new HashMap<>();

        return work(desiredTotal, (1 << maxChoosableInteger) - 1);
    }

    private boolean work(int total, int mask) {
        int key = total + mask * 1000;
        if (ansMap.containsKey(key)) {return ansMap.get(key);}

        int sum = 0;
        for (int i = 0; i < 22; i++) {
            if ((mask & (1 << i)) != 0) {
                sum += i + 1;

                if (i + 1 >= total) {
                    ansMap.put(key, true);
                    return ansMap.get(key);
                }
            }
        }
        if (sum < total) {
            ansMap.put(key, false);
            return ansMap.get(key);
        }

        for (int i = 0; i < 22; i++) {
            if ((mask & (1 << i)) != 0) {
                if (work(total - i - 1, mask ^ (1 << i)) == false) {
                    ansMap.put(key, true);
                    return ansMap.get(key);
                }
            }
        }

        ansMap.put(key, false);
        return ansMap.get(key);
    }


    public static void main(String[] args) {
        System.out.println(new P464_CanIWin().canIWin(15, 104));
    }
}
