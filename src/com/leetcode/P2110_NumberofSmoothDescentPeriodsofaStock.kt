package com.leetcode

/**
 * easy dp
 */
fun getDescentPeriods(prices: IntArray): Long {
    val ans = Array(prices.size) { 1L }

    for (i in 1 until prices.size) {
        if (prices[i] == prices[i - 1] - 1) {
            ans[i] = ans[i - 1] + 1
        }
    }

    return ans.sum()
}
