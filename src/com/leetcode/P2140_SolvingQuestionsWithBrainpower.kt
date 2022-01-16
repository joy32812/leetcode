package com.leetcode

/**
 * DP
 * dp array contains maximum points we get if we start from question i.
 */
fun mostPoints(questions: Array<IntArray>): Long {

    val n = questions.size
    val dp = Array(n) { 0L }

    for (i in questions.indices.reversed()) {
        val (p, b) = questions[i]

        dp[i] = p + (if (i + b + 1 < questions.size) dp[i + b + 1] else 0)
        if (i + 1 < questions.size) {
            dp[i] = Math.max(dp[i], dp[i + 1])
        }
    }

    return dp[0]
}

fun main() {
    println(mostPoints(
        arrayOf(
            intArrayOf(3, 2),
            intArrayOf(4, 3),
            intArrayOf(4, 2),
            intArrayOf(2, 5)
        )
    ))
}
