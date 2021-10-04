package com.leetcode

/**
 * HashMap
 */
fun numOfPairs(nums: Array<String>, target: String): Int {
    val gp = nums.groupBy { it }.mapValues { it.value.size }

    fun getSuffix(s: String) = if (s.length >= target.length || !target.startsWith(s)) "" else target.substring(s.length)

    var ans = 0
    for ((key, value) in gp) {
        val subfix = getSuffix(key)
        if (key == subfix) {
            ans += value * (value - 1)
            continue
        }
        ans += value * (gp[subfix] ?: 0)
    }

    return ans
}

