package com.leetcode

/**
 * DP n^2
 */
fun probabilityOfHeads(prob: DoubleArray, target: Int): Double {

    val n = prob.size
    val dp = Array(n + 1) { Array(n + 1) {0.0} }

    dp[0][0] = 1 - prob[0]
    dp[0][1] = prob[0]

    fun getValue(x: Int, y: Int) = if (x < 0 || y < 0) 0.0 else dp[x][y]

    for (i in 1 until prob.size) {
        for (j in 0..i + 1) {
            dp[i][j] = prob[i] * getValue(i - 1, j - 1) + (1 - prob[i]) * getValue(i - 1, j)
        }
    }

    return dp[n - 1][target]
}
