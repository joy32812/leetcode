package com.leetcode

/**
 * greedy
 */
fun minDeletion(nums: IntArray): Int {

    val arr = mutableListOf<Int>()
    for (d in nums) {
        if (arr.size % 2 == 0 || arr.lastOrNull() != d) {
            arr += d
        }
    }

    val leftSize = if (arr.size % 2 == 1) arr.size - 1 else arr.size
    return nums.size - leftSize
}

fun main() {
    println(minDeletion(intArrayOf(1, 1, 2, 2, 3, 3)))
}
