package com.leetcode;

public class P1025_DivisorGame {

    /**
     * dp
     * dp[i] = true if there is a factor x of N, and dp[i - x] = false
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {

        boolean[] dp = new boolean[N + 1];
        dp[1] = false;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && dp[i - j] == false) {
                    dp[i] = true;
                }
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 1000; i++) {
            System.out.println(new P1025_DivisorGame().divisorGame(i));
        }
        System.out.println(new P1025_DivisorGame().divisorGame(2));
        System.out.println(new P1025_DivisorGame().divisorGame(3));
    }

}
