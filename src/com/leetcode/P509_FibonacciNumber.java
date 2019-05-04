package com.leetcode;

public class P509_FibonacciNumber {


    public int fib(int N) {
        if (N <= 1) return N;

        int a = 0;
        int b = 1;

        for (int i = 2; i <= N; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

}
