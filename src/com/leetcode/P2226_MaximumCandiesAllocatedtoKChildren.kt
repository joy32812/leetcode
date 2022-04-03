package com.leetcode

/**
 * Binary search
 */
fun maximumCandies(candies: IntArray, k: Long): Int {
    if (candies.map { it.toLong() }.sum() < k) return 0

    var l = 0
    var r = candies.max()!! + 1

    fun okay(m: Int) = candies.map { it.toLong() / m }.sum() >= k

    while (l < r) {
        val m = (l + r) / 2

        if (!okay(m)) r = m
        else l = m + 1
    }

    return l - 1
}

fun main() {

    println(maximumCandies(intArrayOf(5, 8, 6), 3))

}
