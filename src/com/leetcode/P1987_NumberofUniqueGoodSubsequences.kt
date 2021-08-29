package com.leetcode

fun numberOfUniqueGoodSubsequences(binary: String): Int {
    if (binary.all { it == '0' }) return 1

    var ans = if (binary.any { it == '0' }) 2L else 1L
    val dp = Array(2) { Array(2) { 0L } }

    val index = binary.indexOfFirst { it == '1' }

    val MOD = 1_000_000_000 + 7

    dp[1][0] = 1L
    dp[1][1] = 1L
    for (i in index + 1 until binary.length) {
        val ch = binary[i]

        val Zero0 = dp[0][0]
        val Zero1 = dp[0][1]
        val One0 = dp[1][0]
        val One1 = dp[1][1]

        if (ch == '0') {
            ans = (ans + dp[0][0] + dp[1][0]) % MOD

            dp[0][0] = (Zero0 + One0) % MOD
            dp[0][1] = (Zero0 + Zero1 + One0) % MOD
            dp[1][0] = 0L
        } else {
            ans = (ans + dp[0][1] + dp[1][1]) % MOD

            dp[0][1] = 0L

            dp[1][0] = (Zero1 + One0 + One1) % MOD;
            dp[1][1] = (Zero1 + One1) % MOD;
        }
    }

    return ans.toInt()
}

fun main() {
    println(numberOfUniqueGoodSubsequences("001"))
    println(numberOfUniqueGoodSubsequences("11"))
    println(numberOfUniqueGoodSubsequences("101"))
}
