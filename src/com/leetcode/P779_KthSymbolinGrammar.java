package com.leetcode;

public class P779_KthSymbolinGrammar {

    public int kthGrammar(int N, int K) {
        if (N == 0) return 0;

        if (K % 2 == 0) {
            int result = kthGrammar(N - 1, K / 2);
            return 1 - result;
        } else {
            int result = kthGrammar(N - 1, K / 2 + 1);
            return result;
        }
    }

}
