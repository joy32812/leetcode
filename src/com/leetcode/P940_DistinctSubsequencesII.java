package com.leetcode;

import java.util.Arrays;

public class P940_DistinctSubsequencesII {



    /**
     * dp[i] means the number of subS ending with S[i] without subS if S[i] occurs before
     * not elegant
     * @param S
     * @return
     */
    public int distinctSubseqII2(String S) {
        if (S == null || S.length() == 0) return 0;

        long MOD = 1000000000l + 7l;

        int[] prev = new int[50];
        Arrays.fill(prev, -1);

        long[] dp = new long[S.length()];
        dp[0] = 1;
        prev[S.charAt(0) - 'a'] = 0;

        for (int i = 1; i < S.length(); i++) {
            int last = prev[S.charAt(i) - 'a'];
            prev[S.charAt(i) - 'a'] = i;

            long total = 0;
            if (last != -1) total = (total + dp[last]) % MOD;
            else total = 1;

            for (int j = last + 1; j < i; j++) {
                total = (total + dp[j]) % MOD;
            }

            dp[i] = total;
        }

        long ans = 0;
        for (int i = 0; i < S.length(); i++) {
            ans = (ans + dp[i]) % MOD;
        }

        return (int) ans;
    }

    /**
     * much more elegant way to do it
     * @param S
     * @return
     */
    public int distinctSubseqII(String S) {

        long mod = (long)1e9 + 7;
        long[] end = new long[26];

        for (char c : S.toCharArray()) {
            end[c - 'a'] = Arrays.stream(end).sum() % mod + 1;
        }

        return (int) (Arrays.stream(end).sum() % mod);
    }



    public static void main(String[] args) {
        System.out.println(new P940_DistinctSubsequencesII().distinctSubseqII("abc"));
        System.out.println(new P940_DistinctSubsequencesII().distinctSubseqII("aba"));
        System.out.println(new P940_DistinctSubsequencesII().distinctSubseqII("aaa"));
        System.out.println(new P940_DistinctSubsequencesII().distinctSubseqII("lee"));

    }

}
