package com.leetcode

/**
 * DP
 * work(l, r, sum) means: the difference when some person picks first
 */
fun stoneGameVII(stones: IntArray): Int {

    val dpMap = mutableMapOf<String, Int>()

    fun work(l: Int, r: Int, sum: Int): Int {
        if (l >= r) return 0
        val key = "" + l + "_" + r
        if (dpMap.containsKey(key)) return dpMap[key]!!
        val ans = Math.max(sum - stones[l] - work(l + 1, r, sum - stones[l]), sum - stones[r] - work(l, r - 1, sum - stones[r]))
        dpMap[key] = ans
        return ans
    }

    return work(0, stones.size - 1, stones.sum())
}

fun main() {
    println("Hello")
}
