package com.leetcode

/**
 * Divide and mod
 */
fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {

    val m = rolls.size
    val left = (m + n) * mean - rolls.sum()

    val min = n
    val max = 6 * n

    if (left < min || left > max) return intArrayOf()

    val avg = left / n
    val z = left % n

    val ans = mutableListOf<Int>()
    (1..z).forEach { ans += avg + 1 }
    (1..n-z).forEach { ans += avg }

    return ans.toIntArray()
}

