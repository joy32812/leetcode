package com.leetcode

/**
 * DP
 * Knapsack
 */
fun minimumNumbers(num: Int, k: Int): Int {

    val dp = Array(num + 10) { Int.MAX_VALUE }
    dp[0] = 0

    for (i in 0 .. num) {
        val x = i * 10 + k
        if (x > num) break

        for (j in 0 .. num) {
            if (j + x > num) break

            if (dp[j] == Int.MAX_VALUE) continue
            dp[j + x] = minOf(dp[j + x], dp[j] + 1)
        }

    }

    return if (dp[num] == Int.MAX_VALUE) -1 else dp[num]
}
