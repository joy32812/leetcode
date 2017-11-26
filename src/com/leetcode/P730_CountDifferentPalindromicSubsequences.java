package com.leetcode;

import java.util.TreeSet;

/**
 * Created by xiaoyuan on 26/11/2017.
 */
public class P730_CountDifferentPalindromicSubsequences {

    int MOD = 1000000000 + 7;
    TreeSet<Integer>[] posTreeSet;
    Integer[][] dp;
    String s;
    public int countPalindromicSubsequences(String S) {
        int n = S.length();

        dp = new Integer[n][n];
        s = S;
        posTreeSet = new TreeSet[26];
        for (int i = 0; i < 26; i++) posTreeSet[i] = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            char ch = S.charAt(i);
            posTreeSet[ch - 'a'].add(i);
        }

        return memo(0, n - 1);
    }

    public int memo(int l,int r){
        if (l > r) return 0;
        if (dp[l][r] != null) return dp[l][r];

        int ans = 0;
        for (int i = 0; i < 26; i++) {

            Integer left = posTreeSet[i].ceiling(l);
            Integer right = posTreeSet[i].floor(r);

            if (left == null) continue;
            if (left > r) continue;

            ans++;
            if (left != right) ans++;
            ans = (ans + memo(left + 1, right - 1)) % MOD;
        }

        return dp[l][r] = ans % MOD;
    }

    public static void main(String[] args) {
        System.out.println(new P730_CountDifferentPalindromicSubsequences().countPalindromicSubsequences("b"));
        System.out.println(new P730_CountDifferentPalindromicSubsequences().countPalindromicSubsequences("bccb"));
    }

}
