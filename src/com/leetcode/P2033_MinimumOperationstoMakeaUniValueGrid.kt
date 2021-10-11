package com.leetcode

/**
 * iterate all the possible answers
 */
fun minOperations(grid: Array<IntArray>, x: Int): Int {
    var nums = grid.flatMap { it.toList() }.sorted()

    var last = 0
    for (d in nums) {
        if ((d - nums[0]) % x != 0) return -1
        last += (d - nums[0]) / x
    }

    var ans = last
    for (i in 1 until nums.size) {
        val k = (nums[i] - nums[i - 1]) / x
        last = last + k * i - (nums.size - i) * k

        ans = Math.min(ans, last)
    }

    return ans
}

fun main() {
    println(minOperations(
        arrayOf(
            intArrayOf(2, 4),
            intArrayOf(6, 8)
        ),
        2
    ))
}
