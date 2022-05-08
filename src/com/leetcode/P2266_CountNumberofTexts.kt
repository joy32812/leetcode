package com.leetcode

/**
 * DP
 * dp[n] = dp[n-1] + dp[n-2] + dp[n-3] +..
 */
fun countTexts(pressedKeys: String): Int {

    val MOD = 1_000_000_000 + 7
    val dp = Array(pressedKeys.length) { 0L }

    for (i in pressedKeys.indices) {
        val k = if (pressedKeys[i] == '7' || pressedKeys[i] == '9') 4 else 3

        for (z in 0 until k) {
            val j = i - z
            if (j < 0) break
            if (pressedKeys[i] != pressedKeys[j]) break

            if (j - 1 < 0) {
                dp[i] = (dp[i] + 1) % MOD
            } else {
                dp[i] = (dp[i] + dp[j - 1]) % MOD
            }
        }
    }

    return dp.last().toInt()
}

fun main() {
    println(countTexts("22222"))
}
