package com.leetcode

/**
 * easy
 * map count
 */
fun maxOperations(nums: IntArray, k: Int): Int {
    val gb = nums.groupBy { it }.mapValues { it.value.size }

    var ans = 0
    for ((num, count) in gb) {
        val left = k - num
        if (!(left in gb.keys)) continue

        if (num == left) ans += count / 2
        else if (num < left)
        else ans += Math.min(count, gb[left]!!)
    }

    return ans
}

fun main() {
    println("Hello")
}
