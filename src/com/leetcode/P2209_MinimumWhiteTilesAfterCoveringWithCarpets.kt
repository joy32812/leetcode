package com.leetcode

/**
 * DP. knapsack
 */
fun minimumWhiteTiles(floor: String, numCarpets: Int, carpetLen: Int): Int {
    val prefixSum = Array(floor.length) { 0 }
    for (i in floor.indices) prefixSum[i] = (if (i - 1 >= 0) prefixSum[i - 1] else 0) + (floor[i] - '0')

    val ansMap = mutableMapOf<Int, Int>()

    fun dfs(i: Int, k: Int): Int {
        if (i < 0) return 0
        if (k == 0) return prefixSum[i]

        val p = i * 1000 + k
        if (p in ansMap) return ansMap[p]!!

        ansMap[p] = Math.min(
            dfs(i - carpetLen, k - 1),
            dfs(i - 1, k) + (floor[i] - '0')
        )

        return ansMap[p]!!
    }

    return dfs(floor.length - 1, numCarpets)
}
