package com.leetcode

/**
 * DP
 * f(n, k) = f(n - 1, k - 1) + (n - 1) * f(n - 1, k)
 */
fun rearrangeSticks(n: Int, k: Int): Int {

    val MOD = 1_000_000_000 + 7
    val dp = Array(n + 1) { Array(n + 1) { -1 } }

    fun dfs(N: Int, K: Int): Int {
        if (K > N || K <= 0) return 0
        if (K == N) return 1
        if (dp[N][K] != -1) return dp[N][K]

        var ans = 0L
        ans = (ans + dfs(N - 1, K - 1)) % MOD
        ans = (ans + 1L * (N - 1) * dfs(N - 1, K)) % MOD

        dp[N][K] = ans.toInt()
        return dp[N][K]
    }

    return dfs(n, k)
}



fun main() {
    println(rearrangeSticks(3, 2))
    println(rearrangeSticks(5, 2))
    println(rearrangeSticks(20, 11))
}
