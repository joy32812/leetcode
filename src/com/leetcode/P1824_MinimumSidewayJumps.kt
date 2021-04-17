package com.leetcode

/**
 * DP
 */
fun minSideJumps(obstacles: IntArray): Int {
    val dp = Array(obstacles.size) { Array(4) { Int.MAX_VALUE / 2 } }
    dp[0][2] = 0
    dp[0][1] = 1
    dp[0][3] = 1

    for (i in 1 until obstacles.size) {
        // from left side
        for (j in 1..3) {
            if (obstacles[i] == j) continue
            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j])
        }

        // from same column
        for (j in 1..3) {
            if (obstacles[i] == j) continue
            val minFromSide = (1..3).map { dp[i][it] }.min()!! + 1
            dp[i][j] = Math.min(dp[i][j], minFromSide)
        }
    }

    return dp[dp.size - 1].min()!!
}

fun main() {
    println(minSideJumps(intArrayOf(0, 1, 2, 3, 0)))
}
