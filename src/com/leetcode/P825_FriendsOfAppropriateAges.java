package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P825_FriendsOfAppropriateAges {

    public int numFriendRequests(int[] ages) {

        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int age : ages) cntMap.put(age, cntMap.getOrDefault(age, 0) + 1);

        int ans = 0;
        for (int b : cntMap.keySet()) {

            int numB = cntMap.get(b);

            for (int a : cntMap.keySet()) {

                if (2 * b <= a + 14) continue;
                if (b > a) continue;
                if (b > 100 && a < 100) continue;

                int numA = cntMap.get(a);

                if (a == b) ans += (numB - 1) * numB;
                else ans += numA * numB;
            }
        }

        return ans;
    }

}
