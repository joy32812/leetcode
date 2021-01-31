package com.leetcode

/**
 * dp
 */
fun checkPartitioning(s: String): Boolean {
    val n = s.length
    val dp = Array(n) { Array(n) {false} }

    for (i in 1..n) {
        for (j in s.indices) {
            val k = j + i - 1
            if (k >= n) continue

            if (j == k) dp[j][k] = true
            else {
                dp[j][k] = (s[j] == s[k]) && (j + 1 == k || dp[j + 1][k - 1])
            }
        }
    }

    for (i in s.indices) {
        for (j in i + 1 until n - 1) {
            if (dp[0][i] && dp[i + 1][j] && dp[j + 1][n - 1]) return true
        }
    }

    return false
}
