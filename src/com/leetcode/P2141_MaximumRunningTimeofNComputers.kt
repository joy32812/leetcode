package com.leetcode

/**
 * Binary search
 */
fun maxRunTime(n: Int, batteries: IntArray): Long {
    var l = 1L
    var r = batteries.map { it.toLong() }.sum() / n + 1

    fun okay(m: Long): Boolean {
        val sum = batteries.map { if (it >= m) m else it.toLong() }.sum()
        return m * n <= sum
    }

    while (l < r) {
        val m = (l + r) / 2
        if (!okay(m)) r = m
        else l = m + 1
    }
    return l - 1
}

fun main() {
    println(maxRunTime(2, intArrayOf(3, 3, 3)))
}
