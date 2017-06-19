package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 19/06/2017.
 */
public class P494_TargetSum {

    private int ans;
    private int A[];
    private int T;
    private Map<Integer, Integer> sumMap;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {return 0;}

        sumMap = new HashMap<>();
        ans = 0;
        A = nums;
        T = S;

        dfs(0, 0);

        return ans;
    }

    private void dfs(int d, int sum) {
        if (d == A.length) {
            if (sum == T) {ans++;}
            return;
        }

        int sum1 = sum + A[d];
        int sum2 = sum - A[d];

        int leftSum = getLeft(d + 1);
        if (T >= sum1 - leftSum && T <= sum1 + leftSum) {
            dfs(d + 1, sum1);
        }
        if (T >= sum2 - leftSum && T <= sum2 + leftSum) {
            dfs(d + 1, sum2);
        }
    }

    private int getLeft(int x) {
        if (x >= A.length) {return 0;}
        if (sumMap.containsKey(x)) {return sumMap.get(x);}
        int sum = 0;
        for (int i = x; i < A.length; i++) {sum += A[i];}
        sumMap.put(x, sum);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new P494_TargetSum().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }



}
