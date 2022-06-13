package com.leetcode

/**
 * dp
 */
fun minPathCost(grid: Array<IntArray>, moveCost: Array<IntArray>): Int {

    val m = grid.size
    val n = grid[0].size

    val dp = Array(m) { IntArray(n) { Int.MAX_VALUE } }

    for (j in 0 until n) {
        dp[0][j] = grid[0][j]
    }

    for (i in 1 until m) {
        for (j in 0 until n) {
            for (k in 0 until n) {
                dp[i][j] = minOf(dp[i][j], dp[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j])
            }
        }
    }

    return dp[m - 1].min()!!

}
