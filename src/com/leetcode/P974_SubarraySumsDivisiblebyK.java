package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P974_SubarraySumsDivisiblebyK {


    /**
     * prefix sum + HashMap
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {

        int ans = 0;
        int n = A.length;
        long[] sum = new long[n];


        Map<Integer, Integer> cntMap = new HashMap<>();
        cntMap.put(0, 1);

        sum[0] = A[0] % K;
        sum[0] = (sum[0] + 2 * K) % K;
        int key = (int) sum[0];
        cntMap.put(key, cntMap.getOrDefault(key, 0) + 1);
        if (sum[0] == 0) ans++;

        for (int i = 1; i < n; i++) {
            sum[i] = (sum[i - 1] + A[i]) % K;
            sum[i] = (sum[i] + 2 * K) % K;



            int now = (K + (int)sum[i]) % K;
            ans += cntMap.getOrDefault(now, 0);

            key = (int) sum[i];
            cntMap.put(key, cntMap.getOrDefault(key, 0) + 1);
        }


        return ans;
    }

    public static void main(String[] args) {

        System.out.println(new P974_SubarraySumsDivisiblebyK().subarraysDivByK(new int[]{8,9,7,8,9}, 8));
//        System.out.println(new BB03().subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
    }

}
