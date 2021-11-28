package com.leetcode

/**
 * Check 3 cases
 */
fun minimumDeletions(nums: IntArray): Int {

    val lowIndex = nums.indices.minBy { nums[it] }!!
    val highIndex = nums.indices.maxBy { nums[it] }!!

    val (l, r) = if (lowIndex < highIndex) Pair(lowIndex, highIndex) else Pair(highIndex, lowIndex)

    return listOf(r + 1, nums.size - l, nums.size - (r - l + 1) + 2).min()!!
}

fun main() {
    println(minimumDeletions(intArrayOf(2, 10, 7, 5, 4, 1, 8, 6)))
}
