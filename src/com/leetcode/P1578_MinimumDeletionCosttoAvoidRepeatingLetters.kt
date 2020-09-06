package com.leetcode

/**
 * DP
 * Also, for a group of continuous same chars, we can delete the group but leave only one char
 * https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/discuss/831588/JavaC%2B%2BPython-Straight-Forward
 */
fun minCost(s: String, cost: IntArray): Int {
    val size = s.length
    val dp = Array(size) { Array(26) {Int.MAX_VALUE} }
    for (j in 0 until 26) {
        if (j == s[0] - 'a') dp[0][j] = 0
        else dp[0][j] = cost[0]
    }

    for (i in 1 until s.length) {
        val charInd = s[i] - 'a'

        // end with
        for (j in 0 until 26) {
            if (j == charInd) continue
            dp[i][charInd] = Math.min(dp[i][charInd], dp[i - 1][j])
        }

        // delete
        for (j in 0 until 26) {
            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + cost[i])
        }
    }

    return dp[size - 1].min()!!
}

fun main() {
    println("HELLO");
}
