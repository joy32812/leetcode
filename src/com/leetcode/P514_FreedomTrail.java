package com.leetcode;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 21/09/2017.
 */
public class P514_FreedomTrail {

    Map<String, Integer> leftMap;
    Map<String, Integer> rightMap;

    public int findRotateSteps(String ring, String key) {

        leftMap = new HashMap<>();
        rightMap = new HashMap<>();
        int n = ring.length();
        int numOfKey = key.length();

        int[][] dp = new int[n][numOfKey];

        for (int j = numOfKey - 1; j >= 0; j --) {
            for (int i = 0; i < n; i++) {

                char keyCh = key.charAt(j);

                int left = getLeft(ring, keyCh, i);
                int right = getRight(ring, keyCh, i);

                if (j + 1 >= numOfKey) {
                    dp[i][j] = Math.min((i - left + n) % n, (right - i + n) % n);
                    continue;
                }

                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (ring.charAt(k) != keyCh) continue;
                    int ll = (i - left + n) % n + Math.min((left - k + n) % n, (k - left + n) % n);
                    int rr = (right - i + n) % n + Math.min((right - k + n) % n, (k - right + n) % n);
                    dp[i][j] = Math.min(dp[i][j], Math.min(ll + dp[k][j + 1], rr + dp[k][j + 1]));
                }

            }
        }


        return dp[0][0] + key.length();
    }


    private int getLeft(String ring, char keyCh, int x) {
        String key = "" + keyCh + "_" + x;
        if (leftMap.containsKey(key)) {
            return leftMap.get(key);
        }
        int n = ring.length();
        while (true) {
            if (ring.charAt(x) == keyCh){
                leftMap.put(key, x);
                return x;
            }
            x = (x + n - 1) % n;
        }
    }
    private int getRight(String ring, char keyCh, int x) {
        String key = "" + keyCh + "_" + x;
        if (rightMap.containsKey(key)) {
            return rightMap.get(key);
        }

        int n = ring.length();
        while (true) {
            if (ring.charAt(x) == keyCh) {
                rightMap.put(key, x);
                return x;
            }
            x = (x + n + 1) % n;
        }
    }

    public static void main(String[] args) {

        System.out.println(new Date().getTime());
        System.out.println(new P514_FreedomTrail().findRotateSteps(
                "uhkmmysrhsdexzosvjckhmepx",
                "eeossmhkschhohucxujosvedukscjrmesmsmkkkmzxsjrmhdkheduzchrppevmxmsrxxkzexjhzkphsyhmssdxmvhhoxypevmymy"
        ));
        System.out.println(new Date().getTime());

//        System.out.println(new P514_FreedomTrail().findRotateSteps("godding", "gd"));
    }

}
