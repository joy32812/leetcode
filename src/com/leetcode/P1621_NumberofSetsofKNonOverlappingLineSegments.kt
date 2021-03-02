package com.leetcode

/**
 * DP
 */
fun numberOfSets(n: Int, k: Int): Int {

    val MOD = 1_000_000_000 + 7
    val dp = Array(n + 1) { Array(k + 1) { 0 } }
    for (i in 1..n) dp[i][0] = 1

    val aboveSum = Array(k + 1) { 0 }

    for (i in 1..n) {
        for (j in 1..k) {
            dp[i][j] = (aboveSum[j - 1] + dp[i - 1][j]) % MOD
        }
        for (j in 0..k) aboveSum[j] = (aboveSum[j] + dp[i][j]) % MOD
    }
    return dp[n][k]
}

fun main() {
    println(numberOfSets(4, 2))
}
