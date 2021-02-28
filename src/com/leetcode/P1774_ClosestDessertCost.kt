package com.leetcode


/**
 * DP
 */
fun closestCost(baseCosts: IntArray, toppingCosts: IntArray, target: Int): Int {

    val dp = Array(30000) { false }
    dp[0] = true

    for (top in toppingCosts) {
        for (j in dp.indices.reversed()) {
            if (!dp[j]) continue

            if (j + top < dp.size) dp[j + top] = true
            if (j + 2 * top < dp.size) dp[j + 2 * top] = true
        }
    }

    var ans = 300000
    for (base in baseCosts) {
        for (j in dp.indices) {
            if (!dp[j]) continue

            if (Math.abs(ans - target) > Math.abs(base + j - target)) ans = j + base
            if (Math.abs(ans - target) == Math.abs(base + j - target) && ans > j + base) ans = j + base
        }
    }

    return ans
}

fun main() {
    println(closestCost(
        intArrayOf(10),
        intArrayOf(1),
        1
    ))
}
