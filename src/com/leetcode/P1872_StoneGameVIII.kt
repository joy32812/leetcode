package com.leetcode

/**
 * DP
 */
fun stoneGameVIII(stones: IntArray): Int {

    val n = stones.size
    val presum = Array(n) { 0 }
    for (i in stones.indices) presum[i] = (if (i - 1 >= 0) presum[i - 1] else 0) + stones[i]

    var ans = presum[n - 1]
    for (i in n - 2 downTo 1) {
        if (presum[i] - ans > ans) ans = presum[i] - ans
    }

    return ans
}
